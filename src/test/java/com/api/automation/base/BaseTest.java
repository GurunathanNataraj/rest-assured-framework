package com.api.automation.base;

import com.api.automation.config.ConfigManager;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import com.api.automation.reporting.ReportEnvironmentListener;

@Listeners(ReportEnvironmentListener.class)
public class BaseTest {

    @BeforeSuite(alwaysRun = true)
    public void setup() {
        String env = ConfigManager.getProperty("env");
        RestAssured.baseURI = ConfigManager.getProperty(env + ".base.url");
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
