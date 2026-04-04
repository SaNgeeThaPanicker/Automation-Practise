package com.tests.ShopingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.ShopingPage.LoginPage;
import com.tests.BaseTest;

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