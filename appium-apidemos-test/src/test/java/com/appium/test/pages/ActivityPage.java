package com.appium.test.pages;

import com.appium.framework.base.AppiumBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSBy;
import io.appium.java_client.pagefactory.iOSFindAll;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("cucumber-glue")
public class ActivityPage extends AppiumBase {

    @AndroidFindBy(id = "left_text")
    @iOSFindBy(id = "some_ios_left_text")
    public static MobileElement LEFT_TEXT;
    @AndroidFindBy(id = "left_text_button")
    @iOSFindBy(id = "some_ios_left_text_button")
    public static MobileElement LEFT_TEXT_BUTTON;
    @AndroidFindBy(id = "left_text_edit")
    @iOSFindBy(id = "some_ios_left_text_edit")
    public static MobileElement LEFT_TEXT_EDIT;
    @AndroidFindAll({@AndroidBy(id = "text1")})
    @iOSFindAll({@iOSBy(id = "some_ios_id_text1")})
    public static List<MobileElement> L_TEXT_1;
    @AndroidFindBy(id = "right_text")
    @iOSFindBy(id = "some_ios_right_text")
    public static MobileElement RIGHT_TEXT;
    @AndroidFindBy(id = "right_text_button")
    @iOSFindBy(id = "some_ios_right_text_button")
    public static MobileElement RIGHT_TEXT_BUTTON;
    @AndroidFindBy(id = "right_text_edit")
    @iOSFindBy(id = "some_ios_right_text_edit")
    public static MobileElement RIGHT_TEXT_EDIT;

    public ActivityPage(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }
}
