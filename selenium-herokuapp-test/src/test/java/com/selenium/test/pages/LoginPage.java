package com.selenium.test.pages;

import com.selenium.framework.base.PageObjectConstruct;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("cucumber-glue")
public class LoginPage extends PageObjectConstruct {

    @FindBy(id = "username")
    public WebElement USERNAME;

    @FindBy(id = "password")
    public WebElement PASSWORD;

    @FindBy(css = "button.radius")
    public WebElement LOGIN_BUTTON;

    @FindBy(css = "a.button.secondary.radius")
    public WebElement LOGOUT_BUTTON;

}
