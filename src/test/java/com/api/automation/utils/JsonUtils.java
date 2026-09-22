package com.api.automation.utils;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class JsonUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T readJsonFile(String filePath, Class<T> targetClass) {
        try {
            InputStream inputStream = JsonUtils.class
                    .getClassLoader()
                    .getResourceAsStream(filePath);

            if (inputStream == null) {
                throw new RuntimeException("JSON file not found");
            }

            return objectMapper.readValue(inputStream, targetClass);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JSON file : " + filePath, e);
        }
    }
}
