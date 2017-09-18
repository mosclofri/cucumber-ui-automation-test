package com.appium.test.stepdefs;

import com.appium.test.pages.AlertDialogsPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static com.appium.test.pages.AlertDialogsPage.BUTTON_1;
import static com.appium.test.pages.AlertDialogsPage.CHECKBOX_BUTTON;
import static com.appium.test.pages.AlertDialogsPage.L_TEXT_1;
import static org.junit.Assert.fail;

public class AlertDialogsStepDefs {

    @Autowired
    private AlertDialogsPage alertDialogsPage;

    @Given("^I am on 'Alert Dialogs' screen$")
    public void givenIAmOnAlertDialogsScreen() {
        L_TEXT_1.get(2).click();
        L_TEXT_1.get(3).click();
    }

    @Given("^I am on 'Repeat Alarm' screen$")
    public void givenIAmOnRepeatAlarmScreen() {
        CHECKBOX_BUTTON.click();
    }

    @Then("^all days should be checked for alarm$")
    public void thenAllDaysShouldBeCheckedForAlarm() {
        givenIAmOnRepeatAlarmScreen();
        alertDialogsPage.androidIsAllChecked(L_TEXT_1);
    }

    @Then("^week days should be checked for alarm$")
    public void thenWeekDaysShouldBeCheckedForAlarm() {
        givenIAmOnRepeatAlarmScreen();
        for (int i = 0; i < 5; i++) {
            if (!alertDialogsPage.androidIsChecked(L_TEXT_1.get(i))) {
                fail("'" + L_TEXT_1.get(i).getText() + "' is not checked");
            }
        }
    }

    @When("^I check all days for alarm$")
    public void whenICheckAllDaysForAlarm() {
        alertDialogsPage.androidCheckAll(L_TEXT_1);
        BUTTON_1.click();
    }

    @When("^I check all week days for alarm$")
    public void whenICheckAllWeekDaysForAlarm() {
        for (int i = 0; i < 5; i++) {
            if (!alertDialogsPage.androidIsChecked(L_TEXT_1.get(i))) {
                L_TEXT_1.get(i).click();
            }
        }
        BUTTON_1.click();
    }

}
