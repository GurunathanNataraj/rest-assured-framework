package com.api.automation.specification;

import com.api.automation.auth.AuthManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {
    public static RequestSpecification getRequestSpec() {
        return new RequestSpecBuilder()
                .setContentType("application/json")
                .setAccept("application/json")
                .addHeader("X-Client-Name","API-Automation")
                .log(LogDetail.ALL)
                .build();
    }

    public static RequestSpecification getAuthenticatedRequestSpec() {
        return new RequestSpecBuilder()
                .setContentType("application/json")
                .setAccept("application/json")
                .addHeader("X-Client-Name","API-Automation")
                .addHeader("Authorization","Bearer "+ AuthManager.getToken())
                .log(LogDetail.ALL)
                .build();
    }
}
