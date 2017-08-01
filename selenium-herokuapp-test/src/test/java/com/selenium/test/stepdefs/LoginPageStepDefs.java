package com.selenium.test.stepdefs;

import com.selenium.test.pages.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginPageStepDefs {

    @Autowired
    public LoginPage loginPage;

    @Given("^I am on 'Login Page' screen$")
    public void givenIAmOnLoginPageScreen() {
        loginPage.getHelper().getURL("/login");
        loginPage.getHelper().assertElementPresent(loginPage.USERNAME, 10);
    }

    @Then("^I 'Home Page' should be displayed$")
    public void thenIHomePageShouldBeDisplayed() {
        loginPage.getHelper().assertElementPresent(loginPage.LOGOUT_BUTTON, 10);
    }

    @When("^I enter '(.*)' as username and '(.*)' as password$")
    public void whenIEnterTomsmithAsUsernameAndSuperSecretPasswordAsPassword(String username, String password) {
        loginPage.USERNAME.sendKeys(username);
        loginPage.PASSWORD.sendKeys(password);
        loginPage.LOGIN_BUTTON.click();
    }

}
