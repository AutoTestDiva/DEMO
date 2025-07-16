package org.nat.demoqa.tests.elements;

import org.nat.demoqa.pages.HomePage;
import org.nat.demoqa.pages.SidePanel;
import org.nat.demoqa.pages.elements.UploadPage;
import org.nat.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RobotTests extends TestBase {
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getElements();
        new SidePanel(driver).selectUpload().hideIframes();
    }
    @Test
    public void performKeyEventWithRobotTest(){
        new UploadPage(driver).performKeyEventWithRobot()
                .assertPath("C:\\fakepath\\D1.txt");
    }

    @Test
    public void performMouseEventTests(){
        new UploadPage(driver).performMouseEvent()
                .assertPath("C:\\fakepath\\D1.txt");
    }
}
