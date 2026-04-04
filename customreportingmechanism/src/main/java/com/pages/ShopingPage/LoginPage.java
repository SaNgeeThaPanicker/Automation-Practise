package com.pages.ShopingPage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BasePage;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By usernameField = By.id("username");
    By passwordField = By.id("password");
    By loginButton = By.id("signInBtn");

    public void enterUsername(String username) {
        enterText(usernameField, username);
    }

    public void enterPassword(String password) {
        enterText(passwordField, password);
    }

    public void clickLogin() {
        clickElement(loginButton);
    }

    public boolean isLoginSuccessful() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    WebElement checkoutButton = wait.until(
        ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector(".nav-link.btn.btn-primary")
        )
    );

    return checkoutButton.isDisplayed();
}

}
