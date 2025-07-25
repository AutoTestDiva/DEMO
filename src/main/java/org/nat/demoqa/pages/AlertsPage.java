package org.nat.demoqa.pages;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AlertsPage extends BasePage {
    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div[class='element-list collapse show'] li[id='item-1'] span[class='text']")
    WebElement jsAlert;

    @FindBy(css = "#alertButton")
    WebElement clickButton;

    public AlertsPage clickOnAlertButton() {
        clickWithJSExecutor(jsAlert, 0, 700);
        clickWithJSExecutor(clickButton, 0, 500);
        return this;
    }


    public AlertsPage acceptAlert() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.alertIsPresent()).accept();
        } catch (NoAlertPresentException ex) {
        }
        return this;
    }

    @FindBy(xpath = "//span[@id='promptResult']")
    WebElement result;

    public AlertsPage verifyPromtBoxResult(String message) {
        Assert.assertTrue(shouldHaveText(result, message, 5));
        return this;
    }

    @FindBy(xpath = "//span[@id='confirmResult']")
    WebElement confirmResult;

    public AlertsPage verifyConfirmResult(String message) {
        Assert.assertTrue(shouldHaveText(confirmResult, message, 5));
        return this;
    }



    @FindBy(css = "#confirmButton")
    WebElement jsConfirm;

    public AlertsPage clickOnConfirmButton() {
        clickWithJSExecutor(jsAlert, 0, 700);
        clickWithJSExecutor(jsConfirm, 0, 700);;
        return this;
    }


    public AlertsPage selectConfirm(String confirm) {
        if (confirm != null && confirm.equalsIgnoreCase("Ok")) {
            driver.switchTo().alert().accept();  //switchTo() - jump in Alert or another window method
        } else if (confirm != null && confirm.equalsIgnoreCase("Cancel")) {
            driver.switchTo().alert().dismiss();
        }
        return this;
    }

    @FindBy(css = "#promtButton")
    WebElement promptButton;

    public AlertsPage clickOnPromptButton() {
        clickWithJSExecutor(jsAlert, 0, 700);
        clickWithJSExecutor(promptButton, 0, 700);
        return this;
    }

    public AlertsPage enterMessageToAlert(String message) {
        if(message != null){
            driver.switchTo().alert().sendKeys(message);
        }
        return this;
    }



}
