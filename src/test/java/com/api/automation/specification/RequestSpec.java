package com.api.automation.specification;

import com.api.automation.auth.AuthManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {

    private static RequestSpecBuilder getBaseRequestSpec() {
        return new RequestSpecBuilder()
                .setContentType("application/json")
                .setAccept("application/json")
                .addHeader("X-Client-Name", "API-Automation")
                .log(LogDetail.ALL);
    }

    public static RequestSpecification getRequestSpec() {
        return getBaseRequestSpec().build();
    }

    public static RequestSpecification getAuthenticatedRequestSpec() {
        return getBaseRequestSpec()
                .addHeader("Authorization", "Bearer " + AuthManager.getToken())
                .build();
    }
}
