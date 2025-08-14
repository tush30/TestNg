package com.logintest.e2e.core;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.InputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class BaseTest {
    protected WebDriver driver;
    protected Properties cfg = new Properties();

    @BeforeMethod
    public void setUp() throws Exception {
        // Load config from classpath instead of hardcoded path
        try (InputStream fis = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (fis == null) {
                throw new FileNotFoundException("config.properties not found in classpath");
            }
            cfg.load(fis);
        }

        // Allow Jenkins or local to override browser via -Dbrowser
        String browser = System.getProperty("browser", cfg.getProperty("browser"));
        DriverFactory.initDriver(browser);
        driver = DriverFactory.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    protected String baseUrl() {
        // Allow Jenkins or local to override baseUrl via -DbaseUrl
        return System.getProperty("baseUrl", cfg.getProperty("baseUrl"));
    }
}
