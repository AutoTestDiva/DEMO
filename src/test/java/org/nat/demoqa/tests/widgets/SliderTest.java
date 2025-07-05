package org.nat.demoqa.tests.widgets;

import org.nat.demoqa.pages.HomePage;
import org.nat.demoqa.pages.SidePanel;
import org.nat.demoqa.pages.widgets.SliderPage;
import org.nat.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SliderTest extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getWidgets();
        new SidePanel(driver).selectSlider();
    }

    @Test
    public void sliderTest() {
        new SliderPage(driver).moveSliderInHorizontalDirection()
                .assertSliderValue("100");
    }
}
