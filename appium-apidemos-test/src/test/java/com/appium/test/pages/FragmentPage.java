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
public class FragmentPage extends AppiumBase {

    @AndroidFindBy(id = "frag1hide")
    @iOSFindBy(id = "some_ios_id_frag1hide")
    public static MobileElement FRAG_HIDE_1;
    @AndroidFindBy(id = "frag2hide")
    @iOSFindBy(id = "some_ios_id_frag2hide")
    public static MobileElement FRAG_HIDE_2;
    @AndroidFindBy(id = "long_press")
    @iOSFindBy(id = "some_ios_id_long_press")
    public static MobileElement LONG_PRESS_BUTTON;
    @AndroidFindAll({@AndroidBy(id = "msg")})
    @iOSFindAll({@iOSBy(id = "some_ios_id_msg")})
    public static List<MobileElement> MSG;

    public FragmentPage(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }
}
