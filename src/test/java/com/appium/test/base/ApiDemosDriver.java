package com.appium.test.base;

import com.appium.api.base.AppiumBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("cucumber-glue")
public class ApiDemosDriver extends AppiumBase {

    @Autowired
    public ApiDemosDriver(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }

}
