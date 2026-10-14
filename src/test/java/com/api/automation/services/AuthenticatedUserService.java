package com.api.automation.services;

import com.api.automation.config.ConfigManager;
import com.api.automation.specification.RequestSpec;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AuthenticatedUserService {

    public Response getAuthenticatedUser() {
        return RestAssured
                .given()
                .spec(RequestSpec.getAuthenticatedRequestSpec())
                .baseUri(ConfigManager.getProperty("auth.base.url"))
                .when()
                .get("/auth/me");

    }
}
