package com.appium.test.stepdefs;

import com.appium.test.base.ApiDemosDriver;
import com.appium.test.objects.AlertDialogsPageObjects;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.fail;

public class AlertDialogsStepDefs extends AlertDialogsPageObjects {

    @Autowired
    public ApiDemosDriver alertDialogsStepDefs;

    @Before
    public void before() {
        alertDialogsStepDefs.initElementsWithFieldDecorator(this);
    }

    @Given("^I am on 'Alert Dialogs' screen$")
    public void givenIAmOnAlertDialogsScreen() {
        L_TEXT_1.get(2).click();
        alertDialogsStepDefs.click(L_TEXT_1, 3);
    }

    @Given("^I am on Repeat Alarm screen$")
    public void givenIAmOnRepeatAlarmScreen() {
        alertDialogsStepDefs.click(CHECKBOX_BUTTON);
    }

    @Then("^all days should be checked for alarm$")
    public void thenAllDaysShouldBeCheckedForAlarm() {
        givenIAmOnRepeatAlarmScreen();
        alertDialogsStepDefs.androidIsAllChecked(L_TEXT_1);
    }

    @Then("^week days should be checked for alarm$")
    public void thenWeekDaysShouldBeCheckedForAlarm() {
        givenIAmOnRepeatAlarmScreen();
        for (int i = 0; i < 5; i++) {
            if (!alertDialogsStepDefs.androidIsChecked(L_TEXT_1, i)) {
                fail("'" + L_TEXT_1.get(i).getText() + "' is not checked");
            }
        }
    }

    @When("^I check all days for alarm$")
    public void whenICheckAllDaysForAlarm() {
        alertDialogsStepDefs.androidCheckAll(L_TEXT_1);
        alertDialogsStepDefs.click(BUTTON_1);
    }

    @When("^I check all week days for alarm$")
    public void whenICheckAllWeekDaysForAlarm() {
        for (int i = 0; i < 5; i++) {
            if (!alertDialogsStepDefs.androidIsChecked(L_TEXT_1, i)) {
                alertDialogsStepDefs.click(L_TEXT_1, i);
            }
        }
        alertDialogsStepDefs.click(BUTTON_1);
    }

}
