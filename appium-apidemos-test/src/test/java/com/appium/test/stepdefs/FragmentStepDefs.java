package com.appium.test.stepdefs;

import com.appium.test.pages.FragmentPage;
import com.appium.test.pages.GenericElements;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static com.appium.test.pages.FragmentPage.FRAG_HIDE_1;
import static com.appium.test.pages.FragmentPage.FRAG_HIDE_2;
import static com.appium.test.pages.FragmentPage.LONG_PRESS_BUTTON;
import static com.appium.test.pages.FragmentPage.MSG;
import static com.appium.test.pages.GenericElements.*;
import static com.appium.test.pages.GenericElements.L_TEXT_1;
import static org.junit.Assert.assertEquals;

public class FragmentStepDefs {

    @Autowired
    private FragmentPage fragmentPage;

    @Autowired
    private GenericElements genericElements;

    @Given("^I am on 'Context Menu' screen$")
    public void givenIAmOnContextMenuScreen() {
        L_TEXT_1.get(2).click();
    }

    @Given("^I am on 'Fragment' screen$")
    public void givenIAmOnFragmentScreen() {
        L_TEXT_1.get(2).click();
        L_TEXT_1.get(5).click();
    }

    @Given("^I am on 'Hide And Show' screen$")
    public void givenIAmOnHideAndShowScreen() {
        L_TEXT_1.get(6).click();
    }

    @Then("^a new pop fragment with 2 item should be displayed$")
    public void thenANewPopFragmentWithItemShouldBeDisplayed() {
        assertEquals(2, TITLE.size());
    }

    @Then("^both fragments should disappear$")
    public void thenBothFragmentsShouldDisappear() {
        assertEquals(0, MSG.size());
    }

    @Then("^I should stay on 'Context Menu' screen$")
    public void thenIShouldStayOnContextMenuScreen() {
        fragmentPage.assertElementPresent(LONG_PRESS_BUTTON);
    }

    @When("^click hide for both fragments$")
    public void whenClickHideForBothFragments() {
        FRAG_HIDE_1.click();
        FRAG_HIDE_2.click();
    }

    @When("^I long press 'Long Press Me' button$")
    public void whenILongPressLongPressMeButton() {
        fragmentPage.longPress(LONG_PRESS_BUTTON, 2);
    }

    @When("^I short press 'Long Press Me' button$")
    public void whenIShortPressLongPressMeButton() {
        LONG_PRESS_BUTTON.click();
    }

}
