package com.api.automation.auth;

import com.api.automation.config.ConfigManager;
import com.api.automation.config.HttpConfig;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.Instant;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class AuthManager {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static String accessToken;
    private static Instant expiresAt;

    public static synchronized String getToken() {
        if(accessToken == null || expiresAt == null || !Instant.now().plusSeconds(30).isBefore(expiresAt)) {
            accessToken = generateToken();
        }
       return accessToken;
    }

    private static String generateToken() {
        String authBaseUrl = ConfigManager.getProperty("auth.base.url");
        String loginEndpoint = ConfigManager.getProperty("auth.login.endpoint");
        String username = ConfigManager.getProperty("auth.username");
        String password = ConfigManager.getProperty("auth.password");
        int expiresInMins = Integer.parseInt(ConfigManager.getProperty("auth.expires.in.mins"));

        Map<String, Object> loginPayload = new HashMap<>();
        loginPayload.put("username",username);
        loginPayload.put("password",password);
        loginPayload.put("expiresInMins",expiresInMins);

        Response response =  RestAssured
                .given()
                .config(HttpConfig.getHttpTimeout())
                .contentType("application/json")
                .body(loginPayload)
                .when()
                .post(authBaseUrl+loginEndpoint);
        response.then().statusCode(200);

        String token = response.jsonPath().getString("accessToken");
        if(token == null || token.isBlank()) {
            throw new IllegalStateException("Login response does not contain a valid accessToken");
        }

        Instant tokenExpiry = readExpiry(token);
        if (!Instant.now().plusSeconds(30).isBefore(tokenExpiry)) {
            throw new IllegalStateException("Login returned a token that expires too soon");
        }
        expiresAt = tokenExpiry;
        return token;
    }

    private static Instant readExpiry(String token) {
        try {
            String[] parts = token.split("\\.",-1);

            if(parts.length != 3) {
                throw new IllegalArgumentException("Invalid JWT structure");
            }

            byte[] payload = Base64.getUrlDecoder().decode(parts[1]);
            JsonNode expiry = OBJECT_MAPPER.readTree(payload).get("exp");
            if (expiry == null || !expiry.isIntegralNumber() || !expiry.canConvertToLong()) {
                throw new IllegalArgumentException("JWT does not contain a valid exp claim");
            }
            return Instant.ofEpochSecond(expiry.longValue());

        } catch (IOException | IllegalArgumentException | DateTimeException e) {
            throw new IllegalStateException("Unable to read access token expiry", e);
        }
    }
}
