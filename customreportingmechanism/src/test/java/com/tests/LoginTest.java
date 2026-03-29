package com.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void verifyPageTitle() {

        // Using driver from BaseTest
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);

        // Assertion
        Assert.assertTrue(title.contains("Login"));
    }

    @Test
    public void verifyURL() {

        // Using prop from BaseTest
        String expectedUrl = prop.getProperty("url");
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl);
    }

@Test
public void verifyLoginFunctionality() {

    LoginPage loginPage = new LoginPage(driver);

    loginPage.enterUsername(prop.getProperty("username"));
    loginPage.enterPassword(prop.getProperty("password"));
    loginPage.clickLogin();

    Assert.assertTrue(loginPage.isLoginSuccessful(), "Login failed");
}

}