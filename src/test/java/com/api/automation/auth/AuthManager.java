package com.api.automation.auth;

import com.api.automation.config.ConfigManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class AuthManager {

    private static String accessToken;

    public static String getToken() {
        if(accessToken == null) {
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
                .contentType("application/json")
                .body(loginPayload)
                .when()
                .post(authBaseUrl+loginEndpoint);
        response.then().statusCode(200);

        return response.jsonPath().getString("accessToken");
    }
}
