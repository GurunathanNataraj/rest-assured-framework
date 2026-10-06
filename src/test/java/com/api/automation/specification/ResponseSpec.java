package com.api.automation.specification;

import com.api.automation.config.ConfigManager;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpec {

    private static ResponseSpecBuilder getBaseResponseSpec() {
        ResponseSpecBuilder builder = new ResponseSpecBuilder();

        boolean isLoggingEnabled = ConfigManager.getBooleanProperty("response.logging.enabled");
        if (isLoggingEnabled) {
            builder.log(LogDetail.ALL);
        }
        return builder;
    }

    public static ResponseSpecification statusCode(int expectedStatusCode) {
        return getBaseResponseSpec()
                .expectStatusCode(expectedStatusCode)
                .build();
    }

    public static ResponseSpecification statusCode200() {
        return statusCode(200);
    }

    public static ResponseSpecification statusCode201() {
        return statusCode(201);
    }

    public static ResponseSpecification statusCode400() {
        return statusCode(400);
    }

    public static ResponseSpecification statusCode404() {
        return statusCode(404);
    }

}
