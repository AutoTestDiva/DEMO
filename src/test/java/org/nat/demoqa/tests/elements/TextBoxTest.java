package org.nat.demoqa.tests.elements;

import org.nat.demoqa.pages.HomePage;
import org.nat.demoqa.pages.SidePanel;
import org.nat.demoqa.pages.elements.TextBoxPage;
import org.nat.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxTest extends TestBase {
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getElements();
        new SidePanel(driver).selectTextBox();
    }
    @Test
    public void keyBoardEventTest(){
        new TextBoxPage(driver).keyBoardEvent("Berlinerstrasse 20")
         //.assertCopyPastText("Berlinerstrasse 20");
         .assertCopyPastText();
    }
}
