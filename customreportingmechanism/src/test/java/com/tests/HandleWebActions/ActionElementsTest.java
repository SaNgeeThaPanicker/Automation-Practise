package com.tests.HandleWebActions;

import org.testng.annotations.Test;

import com.pages.HandleWebActions.PracticeElementActionsPage;
import com.tests.BaseTest;

public class ActionElementsTest extends BaseTest {

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

    @Test
    public void testSuggestedDropdownSelection() throws InterruptedException {
        // Implement dropdown selection test
        PracticeElementActionsPage practicePage = new PracticeElementActionsPage(driver);
        String actualValue = practicePage.selectFromSuggestedDropdown("Ind", "India");

        //Add assertions to verify the correct value is selected
        assert actualValue.equals("India");
    }

}
