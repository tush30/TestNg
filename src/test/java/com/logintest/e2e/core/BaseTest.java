package com.logintest.e2e.core;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class BaseTest {
    protected WebDriver driver;
    protected Properties cfg = new Properties();

    @BeforeMethod
    public void setUp() throws Exception {
        // load config


        try ( InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")){
            cfg.load(input);
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

