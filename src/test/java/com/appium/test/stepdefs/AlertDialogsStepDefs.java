package com.appium.test.stepdefs;

import com.appium.test.pages.AlertDialogsPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.fail;

public class AlertDialogsStepDefs {

    @Autowired
    public AlertDialogsPage alertDialogsPage;

    @Given("^I am on 'Alert Dialogs' screen$")
    public void givenIAmOnAlertDialogsScreen() {
        alertDialogsPage.L_TEXT_1.get(2).click();
        alertDialogsPage.L_TEXT_1.get(3).click();
    }

    @Given("^I am on Repeat Alarm screen$")
    public void givenIAmOnRepeatAlarmScreen() {
        alertDialogsPage.CHECKBOX_BUTTON.click();
    }

    @Then("^all days should be checked for alarm$")
    public void thenAllDaysShouldBeCheckedForAlarm() {
        givenIAmOnRepeatAlarmScreen();
        alertDialogsPage.getAppium().androidIsAllChecked(alertDialogsPage.L_TEXT_1);
    }

    @Then("^week days should be checked for alarm$")
    public void thenWeekDaysShouldBeCheckedForAlarm() {
        givenIAmOnRepeatAlarmScreen();
        for (int i = 0; i < 5; i++) {
            if (!alertDialogsPage.getAppium().androidIsChecked(alertDialogsPage.L_TEXT_1, i)) {
                fail("'" + alertDialogsPage.L_TEXT_1.get(i).getText() + "' is not checked");
            }
        }
    }

    @When("^I check all days for alarm$")
    public void whenICheckAllDaysForAlarm() {
        alertDialogsPage.getAppium().androidCheckAll(alertDialogsPage.L_TEXT_1);
        alertDialogsPage.BUTTON_1.click();
    }

    @When("^I check all week days for alarm$")
    public void whenICheckAllWeekDaysForAlarm() {
        for (int i = 0; i < 5; i++) {
            if (!alertDialogsPage.getAppium().androidIsChecked(alertDialogsPage.L_TEXT_1, i)) {
                alertDialogsPage.L_TEXT_1.get(i).click();
            }
        }
        alertDialogsPage.BUTTON_1.click();
    }

}
