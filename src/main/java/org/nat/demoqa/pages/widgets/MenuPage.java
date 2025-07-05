package org.nat.demoqa.pages.widgets;

import org.nat.demoqa.pages.HomePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MenuPage extends HomePage {

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[.='Main Item 2']")
    WebElement mainItem2;

    @FindBy(xpath = "//a[.='SUB SUB LIST »']")
    WebElement subSubList;

    public MenuPage selectSubMenu() {
        pause(500);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
        pause(500);
        Actions actions = new Actions(driver);
        actions.moveToElement(mainItem2).perform();
        pause(800);
        actions.moveToElement(subSubList).perform();
        pause(800);
        return this;
    }

    public MenuPage assertSubMenu() {
        Assert.assertTrue(subSubList.isDisplayed());
        return this;
    }
}
