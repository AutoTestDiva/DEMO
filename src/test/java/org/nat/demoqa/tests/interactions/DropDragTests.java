package org.nat.demoqa.tests.interactions;

import org.nat.demoqa.pages.HomePage;
import org.nat.demoqa.pages.SidePanel;
import org.nat.demoqa.pages.interactions.DroppablePage;
import org.nat.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDragTests extends TestBase {
    @BeforeMethod
    public void preconditions(){
        new HomePage(driver).getInteractions();
        new SidePanel(driver).selectDroppable().hideIframes();
    }
    @Test
    public void dragMeTest(){
        new DroppablePage(driver).actionDragMe()
                .assertDropped("Dropped!");
    }

    @Test
    public void dragMeByTest(){
        new DroppablePage(driver).actionDragMeBy(20,50)   //using coordinates
                .assertDropped("Dropped!");
    }
}
