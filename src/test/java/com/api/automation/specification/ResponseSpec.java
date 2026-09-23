package com.api.automation.specification;

import com.api.automation.config.ConfigManager;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpec {

    private static ResponseSpecBuilder getBaseResponseSpec() {
        ResponseSpecBuilder builder = new ResponseSpecBuilder();

        boolean isLoggingEnabled = Boolean.parseBoolean(ConfigManager.getProperty("response.logging.enabled"));
        if (isLoggingEnabled) {
            builder.log(LogDetail.ALL);
        }
        return builder;
    }

    public static ResponseSpecification statusCode200() {
        return getBaseResponseSpec()
                .expectStatusCode(200)
                .build();
    }

    public static ResponseSpecification statusCode201() {
        return getBaseResponseSpec()
                .expectStatusCode(201)
                .build();
    }

    public static ResponseSpecification statusCode400() {
        return getBaseResponseSpec()
                .expectStatusCode(400)
                .build();
    }

    public static ResponseSpecification statusCode404() {
        return getBaseResponseSpec()
                .expectStatusCode(404)
                .build();
    }

}
