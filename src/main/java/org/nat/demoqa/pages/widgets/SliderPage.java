package org.nat.demoqa.pages.widgets;

import org.nat.demoqa.pages.HomePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SliderPage extends HomePage {

    public SliderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".range-slider")
    WebElement sliderContainer;
    public SliderPage moveSliderInHorizontalDirection() {
        pause(500);

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
        pause(500);

        new Actions(driver).dragAndDropBy(sliderContainer, 303,15).perform();
        return this;
    }

    @FindBy(id = "sliderValue")
    WebElement sliderValue;

    public SliderPage assertSliderValue(String number) {
        Assert.assertEquals(getValueAttribute(sliderValue, "value"), number);
        return this;
    }

}
