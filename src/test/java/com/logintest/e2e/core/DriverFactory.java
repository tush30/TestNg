package com.logintest.e2e.core;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> TL_DRIVER = new ThreadLocal<>();

    public static void initDriver(String browser) {
        if (getDriver() != null) return;
        switch ((browser == null ? "chrome" : browser).toLowerCase()) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                TL_DRIVER.set(new FirefoxDriver());
                break;
            default:
                WebDriverManager.chromedriver().setup();
                TL_DRIVER.set(new ChromeDriver());
        }
        getDriver().manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return TL_DRIVER.get();
    }

    public static void quitDriver() {
        if (getDriver() != null) {
            getDriver().quit();
            TL_DRIVER.remove();
        }
    }
}

