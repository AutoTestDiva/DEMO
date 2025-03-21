package org.nat.demoqa.tests;

import org.nat.demoqa.pages.HomePage;
import org.nat.demoqa.pages.LoginPage;
import org.nat.demoqa.pages.SidePanel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase{
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getBookStore();
        new SidePanel(driver).selectLogin();
    }

    @Test
    public void loginPositiveTest(){
        new LoginPage(driver)
                .login("Nata", "Nata29101978!")
                .verifyUserName("Nata");
    }
}
