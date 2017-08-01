package com.appium.test.stepdefs;

import com.appium.test.pages.ActivityPage;
import com.appium.test.pages.GenericElements;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertTrue;

public class ActivityStepDefs {

    @Autowired
    public ActivityPage activityPage;

    @Autowired
    public GenericElements genericElements;

    @Given("^I am on 'Activity' screen$")
    public void iAmOnActivityScreen() {
        genericElements.L_TEXT_1.get(2).click();
        genericElements.L_TEXT_1.get(1).click();
    }

    @Given("^I am on 'Custom Title' screen$")
    public void iAmOnCustomTitleScreen() {
        genericElements.L_TEXT_1.get(2).click();
    }

    @Then("^left title should be '(.*)' and right title should be '(.*)'$")
    public void thenLeftTitleShouldBeLeftTextAndRightTitleShouldBeRightText(String left, String right) {
        assertTrue(activityPage.LEFT_TEXT.getText().equals(left));
        assertTrue(activityPage.RIGHT_TEXT.getText().equals(right));
    }

    @When("^I set left title to '(.*)' and right title to '(.*)'$")
    public void whenISetLeftTitleToLeftTextAndRightTitleToRightText(String left, String right) {
        activityPage.LEFT_TEXT_EDIT.clear();
        activityPage.LEFT_TEXT_EDIT.setValue(left);
        activityPage.LEFT_TEXT_BUTTON.click();

        activityPage.RIGHT_TEXT_EDIT.clear();
        activityPage.RIGHT_TEXT_EDIT.setValue(right);
        activityPage.RIGHT_TEXT_BUTTON.click();
    }

}
