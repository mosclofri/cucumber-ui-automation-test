package com.appium.test.objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindAll;
import io.appium.java_client.pagefactory.iOSFindBy;

import java.util.List;

public class AlertDialogsPageObjects {

    @AndroidFindAll({@AndroidFindBy(id = "text1")})
    @iOSFindAll({@iOSFindBy(id = "some_ios_id_text1")})
    protected List<MobileElement> L_TEXT_1;

    @AndroidFindBy(id = "checkbox_button")
    @iOSFindBy(id = "some_ios_id_checkbox_button")
    protected MobileElement CHECKBOX_BUTTON;

    @AndroidFindBy(id = "button1")
    @iOSFindBy(id = "some_ios_id_button_1")
    protected MobileElement BUTTON_1;

}
