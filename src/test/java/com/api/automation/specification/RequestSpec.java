package com.api.automation.specification;

import com.api.automation.auth.AuthManager;
import com.api.automation.config.ConfigManager;
import com.api.automation.config.HttpConfig;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {

    private static RequestSpecBuilder getBaseRequestSpec() {

        RequestSpecBuilder builder = new RequestSpecBuilder()
                .setConfig(HttpConfig.getHttpTimeout())
                .setContentType("application/json")
                .setAccept("application/json")
                .addFilter(new AllureRestAssured()
                        .setRequestTemplate("api-request.ftl")
                        .setResponseTemplate("api-response.ftl"))
                .addHeader("X-Client-Name", "API-Automation");
        boolean isLoggingEnabled = ConfigManager.getBooleanProperty("request.logging.enabled");

        if (isLoggingEnabled) {
            builder.log(LogDetail.ALL);
        }
        return builder;
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
