package com.selenium.test.stepdefs;

import com.selenium.test.pages.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static com.selenium.test.pages.LoginPage.LOGIN_BUTTON;
import static com.selenium.test.pages.LoginPage.LOGOUT_BUTTON;
import static com.selenium.test.pages.LoginPage.PASSWORD;
import static com.selenium.test.pages.LoginPage.USERNAME;

public class LoginPageStepDefs {

    @Autowired
    public LoginPage loginPage;

    @Given("^I am on 'Login Page' screen$")
    public void givenIAmOnLoginPageScreen() {
        loginPage.getURL("/login");
        loginPage.assertElementPresent(USERNAME, 10);
    }

    @Then("^I 'Home Page' should be displayed$")
    public void thenIHomePageShouldBeDisplayed() {
        loginPage.assertElementPresent(LOGOUT_BUTTON, 10);
    }

    @When("^I enter '(.*)' as username and '(.*)' as password$")
    public void whenIEnterTomsmithAsUsernameAndSuperSecretPasswordAsPassword(String username, String password) {
        USERNAME.sendKeys(username);
        PASSWORD.sendKeys(password);
        LOGIN_BUTTON.click();
    }

}
