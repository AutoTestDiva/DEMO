package org.nat.demoqa.pages.widgets;

import org.nat.demoqa.pages.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AutoCompletePage extends BasePage {
    public AutoCompletePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "autoCompleteMultipleInput")
    WebElement autoCompleteMultipleInput;
    public AutoCompletePage autoComplete() {
        autoCompleteMultipleInput.sendKeys("a");
        autoCompleteMultipleInput.sendKeys(Keys.DOWN, Keys.ENTER);
        return this;
    }

    @FindBy(id = "autoCompleteMultipleContainer")
    WebElement autoCompleteMultipleContainer;
    public AutoCompletePage assertAutoComplete(String color) {
        Assert.assertTrue(shouldHaveText(autoCompleteMultipleContainer,color,5));
        return this;
    }
}
