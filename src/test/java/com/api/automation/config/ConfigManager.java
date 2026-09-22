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
        return properties.getProperty(key);
   }
}
