package org.nat.demoqa.tests.widgets;

import org.nat.demoqa.pages.HomePage;
import org.nat.demoqa.pages.SidePanel;
import org.nat.demoqa.pages.widgets.ToolTipsPage;
import org.nat.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ToolTipsTest extends TestBase {
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getWidgets();
        new SidePanel(driver).selectToolTips().hideIframes();
    }

    @Test
    public void toolTipsTest(){
        new ToolTipsPage(driver).hoverToolTips()
                .assertToolTips("textFieldToolTip");
    }
}
