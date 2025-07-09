package org.nat.demoqa.tests.interactions;

import org.nat.demoqa.pages.HomePage;
import org.nat.demoqa.pages.SidePanel;
import org.nat.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;

public class DropDragTests extends TestBase {
    @BeforeMethod
    public void preconditions(){
        new HomePage(driver).getInteractions();
        new SidePanel(driver).selectDroppable();
    }
}
