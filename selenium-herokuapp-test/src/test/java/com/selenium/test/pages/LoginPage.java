package com.selenium.test.pages;

import com.selenium.framework.base.SeleniumBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("cucumber-glue")
public class LoginPage extends SeleniumBase {

    @FindBy(css = "button.radius")
    public static WebElement LOGIN_BUTTON;
    @FindBy(css = "a.button.secondary.radius")
    public static WebElement LOGOUT_BUTTON;
    @FindBy(id = "password")
    public static WebElement PASSWORD;
    @FindBy(id = "username")
    public static WebElement USERNAME;

    public LoginPage(WebDriver driver) {
        super(driver);
    }
}
