package org.nat.demoqa.tests.elements;

import org.nat.demoqa.pages.HomePage;
import org.nat.demoqa.pages.SidePanel;
import org.nat.demoqa.pages.elements.ButtonsPage;
import org.nat.demoqa.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonsTests extends TestBase {
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getElements();
        new SidePanel(driver).selectButtons();
    }
    @Test
    public void doubleClickTest(){
       new ButtonsPage(driver).doubleClick()
               .assertDoubleClick("You have done a double click");

    }
    @Test
    public void rightClickTest(){
        new ButtonsPage(driver).rightClick()
                .assertRightClick("You have done a right click");
    }
}
