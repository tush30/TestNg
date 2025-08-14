package com.logintest.e2e.tests;


import com.logintest.e2e.core.BaseTest;
import com.logintest.e2e.pages.HomePage;
import com.logintest.e2e.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    WebDriver driver;
    @Test
    public void validLogin_shouldLandOnHome() {
        HomePage home = new LoginPage(driver)
                .open(baseUrl())
                .typeUsername("student")
                .typePassword("Password123")
                .submit();


        Assert.assertTrue(home.isLoaded(), "Home page did not load after login!");
    }
}

