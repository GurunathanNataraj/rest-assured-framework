package com.api.automation.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
    private static final Properties properties = new Properties();

   static {
       try(InputStream inputStream = ConfigManager.class.getClassLoader().getResourceAsStream("config/config.properties")) {
           if (inputStream==null) {
               throw new RuntimeException("config.properties file not found");
           }
           properties.load(inputStream);
       } catch (IOException e) {
           throw new RuntimeException("Failed to load config.properties",e);
       }
   }

   public static String getProperty(String key) {
        String systemProperty = System.getProperty(key);
        if (systemProperty != null && !systemProperty.isBlank()) {
            return systemProperty;
        }
        String value = properties.getProperty(key);
        if(value == null || value.isBlank()) {
            throw new RuntimeException("Missing config property : "+key);
        }
        return value;
   }
}
