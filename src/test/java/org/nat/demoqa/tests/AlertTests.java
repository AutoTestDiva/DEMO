package org.nat.demoqa.tests;

import org.nat.demoqa.pages.AlertsPage;
import org.nat.demoqa.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getAlerts();
    }

        @Test
    public void acceptAlert(){
        new AlertsPage(driver).clickOnAlertButton()
                .acceptAlert();
        }

        @Test
    public void confirmAlertTest(){
        new AlertsPage(driver).clickOnConfirmButton()
                .selectConfirm("Cancel")
                .verifyConfirmResult("You selected Cancel");
        }

        @Test
        public void sendMessageToAlertTest(){
        new AlertsPage(driver).clickOnPromptButton()
                .enterMessageToAlert("Hello")
                .acceptAlert()
                .verifyPromtBoxResult("You entered Hello");
        }

}
