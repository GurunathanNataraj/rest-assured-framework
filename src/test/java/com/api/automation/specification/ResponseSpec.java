package com.api.automation.specification;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpec {

    public static ResponseSpecification statusCode200() {
       return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .log(LogDetail.ALL)
                .build();
    }

    public static ResponseSpecification statusCode201() {
        return new ResponseSpecBuilder()
                .expectStatusCode(201)
                .log(LogDetail.ALL)
                .build();
    }

    public static ResponseSpecification statusCode400() {
        return new ResponseSpecBuilder()
                .expectStatusCode(400)
                .log(LogDetail.ALL)
                .build();
    }

    public static ResponseSpecification statusCode404() {
        return new ResponseSpecBuilder()
                .expectStatusCode(404)
                .log(LogDetail.ALL)
                .build();
    }

}
