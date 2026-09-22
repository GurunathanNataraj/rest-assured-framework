package com.api.automation.services;

import com.api.automation.constants.Endpoints;
import com.api.automation.models.User;
import com.api.automation.specification.RequestSpec;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UserService {

    public Response getUserById(int userId) {
        return RestAssured
                .given()
                .spec(RequestSpec.getRequestSpec())
                .when()
                .get(Endpoints.USERS + "/" + userId);
    }

    public Response createUser(User user) {
        return RestAssured
                .given()
                .spec(RequestSpec.getRequestSpec())
                .body(user)
                .when()
                .post(Endpoints.USERS);
    }

    public Response updateUser(int userId, User user) {
        return RestAssured
                .given()
                .spec(RequestSpec.getRequestSpec())
                .body(user)
                .when()
                .put(Endpoints.USERS + "/" + userId);
    }
}
