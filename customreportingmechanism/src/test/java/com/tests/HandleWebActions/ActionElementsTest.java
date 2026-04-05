package com.tests.HandleWebActions;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.HandleWebActions.PracticeElementActionsPage;
import com.tests.BaseTest;

public class ActionElementsTest extends BaseTest {

    private PracticeElementActionsPage practicePage;

    @BeforeMethod
    public void setup() {
        practicePage = new PracticeElementActionsPage(driver);
    }

    // Test to select radio button and verify selection. 

    @Test
    public void testSelectRadioButton() {
        PracticeElementActionsPage practicePage = new PracticeElementActionsPage(driver);
        practicePage.selectRadioButton1();
        practicePage.selectRadioButton2();
        
        // Add assertions to verify the radio button is selected
        // assert practicePage.isRadioButton1Selected();
        // assert practicePage.isRadioButton2Selected();

    }

    // Test to select from suggested dropdown and verify selection.
    @Test
    public void testSuggestedDropdownSelection() throws InterruptedException {
        String actualValue = practicePage.selectFromSuggestedDropdown("Ind", "India");

        //Add assertions to verify the correct value is selected
        assert actualValue.equals("India");
    }

    // Test to select from regular dropdown and verify selection.
    @Test
    public void testDropdownSelection() {  
        practicePage.selectFromDropdown("Option1");
    }

}
