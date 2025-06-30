package org.nat.demoqa.tests.widgets;

import org.nat.demoqa.pages.HomePage;
import org.nat.demoqa.pages.SidePanel;
import org.nat.demoqa.pages.widgets.AutoCompletePage;
import org.nat.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutoCompleteTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getWidgets();
        new SidePanel(driver).selectAutoComplete();
    }

    @Test
    public void autoCompleteTest() {
        new AutoCompletePage(driver).autoComplete()
                .assertAutoComplete("Magenta");
    }
}
