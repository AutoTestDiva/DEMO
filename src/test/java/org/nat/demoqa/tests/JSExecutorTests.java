package org.nat.demoqa.tests;

import org.nat.demoqa.data.UserData;
import org.nat.demoqa.pages.HomePage;
import org.nat.demoqa.pages.JSExecutor;
import org.testng.annotations.Test;

public class JSExecutorTests extends TestBase {   // for site http://the-internet.herokuapp.com/

    @Test
    public void JSExecutorTest(){
        new HomePage(driver).getFormAuthentication();
        new JSExecutor(driver)
                .enterDataWithJSE(UserData.USER_NAME, UserData.USER_PASSWORD)
                .clickOnLoginButtonWithJSE()
                .checkURLWithJSE();

    }
}
