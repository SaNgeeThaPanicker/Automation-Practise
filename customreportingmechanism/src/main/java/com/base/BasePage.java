package com.base;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // A reusable click method used by ALL pages
    public void clickElement(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    // A reusable method to get text from an element
    public String getElementText(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    // A reusable method to enter text into an input field
    public void enterText(By locator, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }

    // A reusable method to select a radio button by value
    public void selectRadioButtonByValue(By locator, String valueToSelect) {
        List<WebElement> radioButtons = driver.findElements(locator);

        for (WebElement radio : radioButtons) {
            String actualValue = radio.getAttribute("value");
            if (actualValue != null && actualValue.equals(valueToSelect)) {
                if (!radio.isSelected()) {
                    radio.click();
                }
                break;
            }
        }
    }

    public String selectSuggestion(String inputText, String targetSelection) {

        WebElement searchInput = driver.findElement(By.id("autocomplete"));
        searchInput.clear();
        searchInput.sendKeys(inputText);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for the dropdown options to be visible
        List<WebElement> options = wait.until(
            ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.cssSelector(".ui-menu-item")
            )
        );

        // Iterate through the options and click the one that matches the target selection
        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase(targetSelection)) {
                option.click();
                break;
            }
        }

        // Return the value from the input field after selection
        String actualValue = searchInput.getAttribute("value");
        return actualValue;
    }
}
