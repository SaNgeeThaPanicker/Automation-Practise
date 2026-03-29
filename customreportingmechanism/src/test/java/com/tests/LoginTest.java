package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin() {
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        LoginPage login = new LoginPage(driver);
        login.enterUsername("rahulshettyacademy");
        login.enterPassword("Learning@830$3mK2");
        login.clickLogin();
        // Add assertions to verify successful login
        // Assert.assertTrue(driver.getCurrentUrl().equals("https://rahulshettyacademy.com/angularpractice/shop"), "Login failed, incorrect URL reached");
    }
}


