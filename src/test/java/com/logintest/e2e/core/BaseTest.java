package com.logintest.e2e.core;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.util.Properties;

public class BaseTest {
    protected WebDriver driver;
    protected Properties cfg = new Properties();

    @BeforeMethod
    public void setUp() throws Exception {
        // load config
        try (FileInputStream fis = new FileInputStream("C:\\Users\\tushr\\IdeaProjects\\SeleniumIntegrationJenkins\\src\\main\\java\\resources\\config.properties")) {
            cfg.load(fis);
        }
        String browser = System.getProperty("browser", cfg.getProperty("browser"));
        DriverFactory.initDriver(browser);
        driver = DriverFactory.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    protected String baseUrl() {
        return System.getProperty("baseUrl", cfg.getProperty("baseUrl"));
    }
}

