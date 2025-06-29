package org.nat.demoqa.tests.alertsFramesWindows;

import org.nat.demoqa.pages.HomePage;
import org.nat.demoqa.pages.SidePanel;
import org.nat.demoqa.pages.alertsFramesWindows.FramesPage;
import org.nat.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframesTests extends TestBase {
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getAlertsFramesWindows();
    }
    @Test
    public void iframesTest(){
        new SidePanel(driver).selectFrames();
        new FramesPage(driver).returnListOfFrames().switchToIframeByIndex(1);

    }

}
