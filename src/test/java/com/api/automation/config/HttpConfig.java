package com.api.automation.config;

import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;

public class HttpConfig {

    public static RestAssuredConfig getHttpTimeout() {
       int connectionTimeout = ConfigManager.getIntProperty("http.connection.timeout.ms");
       int socketTimeout = ConfigManager.getIntProperty("http.socket.timeout.ms");

        if (connectionTimeout <= 0) {
            throw new IllegalArgumentException(
                    "http.connection.timeout.ms must be greater than zero");
        }

        if (socketTimeout <= 0) {
            throw new IllegalArgumentException(
                    "http.socket.timeout.ms must be greater than zero");
        }
        return RestAssuredConfig.config()
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam("http.connection.timeout",connectionTimeout)
                        .setParam("http.socket.timeout",socketTimeout));
    }
}
