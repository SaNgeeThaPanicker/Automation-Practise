package com.pages.HandleWebActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.base.BasePage;

public class PracticeElementActionsPage extends BasePage {

    public PracticeElementActionsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    By radioButtonValue1= By.cssSelector("input[value='radio1']");
    By radioButtonValue2= By.cssSelector("input[value='radio2']");

    public void selectRadioButton1() {
        selectRadioButtonByValue(radioButtonValue1,"radio1");
    }

    public void selectRadioButton2() {
        selectRadioButtonByValue(radioButtonValue2,"radio2");
    }

    public boolean isRadioButton1Selected() {
        return driver.findElement(radioButtonValue1).isSelected();
    }

    public boolean isRadioButton2Selected() {
        return driver.findElement(radioButtonValue2).isSelected();
    }

    public String selectFromSuggestedDropdown(String inputText, String targetSelection) throws InterruptedException {
        return selectSuggestion(inputText, targetSelection);
    }
}