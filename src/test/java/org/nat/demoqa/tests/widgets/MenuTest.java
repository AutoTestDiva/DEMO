package org.nat.demoqa.tests.widgets;

import org.nat.demoqa.pages.HomePage;
import org.nat.demoqa.pages.SidePanel;
import org.nat.demoqa.pages.widgets.MenuPage;
import org.nat.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MenuTest extends TestBase {
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getWidgets();
        new SidePanel(driver).selectMenu();
    }
    @Test
    public void selectMenuTest(){
        new MenuPage(driver).selectSubMenu()
                .assertSubMenu();
    }
}
