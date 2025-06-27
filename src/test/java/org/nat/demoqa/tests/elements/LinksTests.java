package org.nat.demoqa.tests.elements;

import org.nat.demoqa.pages.HomePage;
import org.nat.demoqa.pages.SidePanel;
import org.nat.demoqa.pages.elements.LinksPage;
import org.nat.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinksTests extends TestBase {
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getElements();
    }
    @Test
    public void getAllLinksTest(){
        new SidePanel(driver).selectLinks();
        new LinksPage(driver).getAllLinks();
    }
    @Test
    public void checkBrokenLinksTest(){
        new SidePanel(driver).selectLinks();
        new LinksPage(driver).checkBrokenLinks();
    }
}
