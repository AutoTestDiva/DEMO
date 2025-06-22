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
                .acceptAlert()
                .verifyResult("You  clicked a button");
        }

        @Test
    public void confirmAlertTest(){
        new AlertsPage(driver).cliOnConfirmButton()
                .selectConfirm("Cancel")
                .verifyResult("Cancel");
        }

        @Test
        public void sendMessageToAlertTest(){
        new AlertsPage(driver).clickOnPromptButton()
                .enterMessageToAlert("Hello")
                .acceptAlert()
                .verifyResult("Hello");
        }

}
