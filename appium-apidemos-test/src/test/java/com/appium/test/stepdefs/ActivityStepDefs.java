package com.appium.test.stepdefs;

import com.appium.test.pages.ActivityPage;
import com.appium.test.pages.GenericElements;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static com.appium.test.pages.ActivityPage.*;
import static com.appium.test.pages.GenericElements.L_TEXT_1;
import static org.junit.Assert.assertTrue;

public class ActivityStepDefs {

    @Autowired
    private ActivityPage activityPage;

    @Autowired
    private GenericElements genericElements;

    @Given("^I am on 'Activity' screen$")
    public void iAmOnActivityScreen() {
        L_TEXT_1.get(2).click();
        L_TEXT_1.get(1).click();
    }

    @Given("^I am on 'Custom Title' screen$")
    public void iAmOnCustomTitleScreen() {
        L_TEXT_1.get(2).click();
    }

    @Then("^left title should be '(.*)' and right title should be '(.*)'$")
    public void thenLeftTitleShouldBeLeftTextAndRightTitleShouldBeRightText(String left, String right) {
        assertTrue(LEFT_TEXT.getText().equals(left));
        assertTrue(RIGHT_TEXT.getText().equals(right));
    }

    @When("^I set left title to '(.*)' and right title to '(.*)'$")
    public void whenISetLeftTitleToLeftTextAndRightTitleToRightText(String left, String right) {
        LEFT_TEXT_EDIT.clear();
        LEFT_TEXT_EDIT.setValue(left);
        LEFT_TEXT_BUTTON.click();

        RIGHT_TEXT_EDIT.clear();
        RIGHT_TEXT_EDIT.setValue(right);
        RIGHT_TEXT_BUTTON.click();
    }

}
