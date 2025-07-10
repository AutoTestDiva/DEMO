package org.nat.demoqa.pages.interactions;

import org.nat.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DroppablePage extends BasePage {

    public DroppablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "draggable")
    WebElement dragMe;

    @FindBy(id = "droppable")
    WebElement dropHere;

    public DroppablePage actionDragMe() {
        pause(1000);
        clickWithJSExecutor(dragMe, 0, 500);
        new Actions(driver).dragAndDrop(dragMe, dropHere).perform();
        return this;
    }

    public DroppablePage assertDropped(String text) {
        Assert.assertTrue(isTextPresent(dropHere, text));
        return this;
    }
}
