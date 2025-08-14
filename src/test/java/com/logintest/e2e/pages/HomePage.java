package com.logintest.e2e.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;
    private final By welcomeBanner = By.linkText("Log out");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isLoaded() {
        System.out.println("hello tushar RathodHBTFDH kavya tetsing");
        return !driver.findElements(welcomeBanner).isEmpty();
    }
}

