package org.nat.demoqa.tests;

import org.nat.demoqa.pages.HomePage;
import org.nat.demoqa.pages.WindowPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewTabTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getMultipleWindows();
    }
    @Test
    public void switchToNewTabTest(){
        new WindowPage(driver).switchToNewTab(1)
                .verifyNewTabTitle("New Window");
    }

}
