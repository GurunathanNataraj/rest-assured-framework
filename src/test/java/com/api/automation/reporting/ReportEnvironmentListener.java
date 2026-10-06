package com.api.automation.reporting;

import com.api.automation.config.ConfigManager;
import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.Parameter;
import io.qameta.allure.model.TestResult;
import org.testng.ISuite;
import org.testng.ISuiteListener;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class ReportEnvironmentListener implements ISuiteListener, TestLifecycleListener {
    private static final DateTimeFormatter TIMESTAMP_FORMAT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS XXX");

    @Override
    public void beforeTestWrite(TestResult result) {
        addTimestamp(result, "Execution start", result.getStart());
        addTimestamp(result, "Execution end", result.getStop());
    }

    private static void addTimestamp(TestResult result, String name, Long timestamp) {
        if (timestamp != null) {
            String value = TIMESTAMP_FORMAT.format(
                    Instant.ofEpochMilli(timestamp).atZone(ZoneId.systemDefault()));
            result.getParameters().add(new Parameter()
                    .setName(name)
                    .setValue(value)
                    .setExcluded(true));
        }
    }

    @Override
    public void onStart(ISuite suite) {
        String env = ConfigManager.getProperty("env");
        Properties metadata = new Properties();
        metadata.setProperty("Environment", env);
        metadata.setProperty("Base URL", ConfigManager.getProperty(env + ".base.url"));
        metadata.setProperty("Java version", System.getProperty("java.version"));

        Properties allureConfig = new Properties();
        try (var input = getClass().getClassLoader().getResourceAsStream("allure.properties")) {
            if (input != null) {
                allureConfig.load(input);
            }
            Path results = Path.of(System.getProperty("allure.results.directory",
                    allureConfig.getProperty("allure.results.directory", "target/allure-results")));
            Files.createDirectories(results);
            try (OutputStream output = Files.newOutputStream(results.resolve("environment.properties"))) {
                metadata.store(output, "API test environment");
            }
        } catch (IOException e) {
            throw new IllegalStateException("Failed to write Allure environment metadata", e);
        }
    }
}
