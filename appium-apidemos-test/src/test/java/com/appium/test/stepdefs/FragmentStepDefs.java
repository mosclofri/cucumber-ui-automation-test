package com.appium.test.stepdefs;

import com.appium.test.pages.FragmentPage;
import com.appium.test.pages.GenericElements;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.TouchAction;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class FragmentStepDefs {

    @Autowired
    public FragmentPage fragmentPage;

    @Autowired
    public GenericElements genericElements;

    @Given("^I am on 'Context Menu' screen$")
    public void givenIAmOnContextMenuScreen() {
        genericElements.L_TEXT_1.get(2).click();
    }

    @Given("^I am on 'Fragment' screen$")
    public void givenIAmOnFragmentScreen() {
        genericElements.L_TEXT_1.get(2).click();
        genericElements.L_TEXT_1.get(5).click();
    }

    @Given("^I am on 'Hide And Show' screen$")
    public void givenIAmOnHideAndShowScreen() {
        genericElements.L_TEXT_1.get(6).click();
    }

    @Then("^a new pop fragment with 2 item should be displayed$")
    public void thenANewPopFragmentWithItemShouldBeDisplayed() {
        assertEquals(2, genericElements.TITLE.size());
    }

    @Then("^both fragments should disappear$")
    public void thenBothFragmentsShouldDisappear() {
        assertEquals(0, fragmentPage.MSG.size());
    }

    @Then("^I should stay on 'Context Menu' screen$")
    public void thenIShouldStayOnContextMenuScreen() {
        fragmentPage.getHelper().assertElementPresent(fragmentPage.LONG_PRESS_BUTTON);
    }

    @When("^click hide for both fragments$")
    public void whenClickHideForBothFragments() {
        fragmentPage.FRAG_HIDE_1.click();
        fragmentPage.FRAG_HIDE_2.click();
    }

    @When("^I long press 'Long Press Me' button$")
    public void whenILongPressLongPressMeButton() {
        TouchAction action = new TouchAction(fragmentPage.getDriver());
        action.longPress(fragmentPage.LONG_PRESS_BUTTON, 2).perform().release();
    }

    @When("^I short press 'Long Press Me' button$")
    public void whenIShortPressLongPressMeButton() {
        fragmentPage.LONG_PRESS_BUTTON.click();
    }

}
