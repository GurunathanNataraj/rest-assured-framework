package com.api.automation.specification;

import com.api.automation.auth.AuthManager;
import com.api.automation.config.ConfigManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {

    private static RequestSpecBuilder getBaseRequestSpec() {
        RequestSpecBuilder builder = new RequestSpecBuilder()
                .setContentType("application/json")
                .setAccept("application/json")
                .addHeader("X-Client-Name", "API-Automation");
     boolean isLoggingEnabled = Boolean.parseBoolean(ConfigManager.getProperty("request.logging.enabled"));

     if(isLoggingEnabled) {
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
