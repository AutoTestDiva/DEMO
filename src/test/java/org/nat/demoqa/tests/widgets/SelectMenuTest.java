package org.nat.demoqa.tests.widgets;

import org.nat.demoqa.pages.HomePage;
import org.nat.demoqa.pages.SidePanel;
import org.nat.demoqa.pages.widgets.SelectMenuPage;
import org.nat.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectMenuTest extends TestBase {
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getWidgets();
        new SidePanel(driver).selectSelectMenu();
    }
    @Test
    public void selectOldStyleTest(){
        new SelectMenuPage(driver).selectOldStyle("Blue");
    }
    @Test
    public void multiSelectTest(){
        new SelectMenuPage(driver).multiSelect(new String[]{"Blue", "Black", "Red"});
    }

    @Test  //The same like multiSelectTest, but when I cannot recognize xpass of color
    public void multiSelectTest1(){
        new SelectMenuPage(driver).multiSelect1(new String[]{"Blue", "Black", "Red"});
    }
    @Test
    public void standardMultiSelectTest(){
        new SelectMenuPage(driver).standardMultiSelect(2);

    }
}
