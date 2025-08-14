package com.logintest.e2e.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;

    private final By user = By.id("username");
    private final By pass = By.id("password");
    private final By submit = By.id("submit");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage open(String baseUrl) {
        driver.get(baseUrl);
        return this;
    }

    public LoginPage typeUsername(String val) {
        driver.findElement(user).clear();
        driver.findElement(user).sendKeys(val);
        return this;
    }

    public LoginPage typePassword(String val) {
        driver.findElement(pass).clear();
        driver.findElement(pass).sendKeys(val);
        return this;
    }

    public HomePage submit() {
        driver.findElement(submit).click();
        return new HomePage(driver);
    }
}

