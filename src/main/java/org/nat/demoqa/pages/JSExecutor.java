package org.nat.demoqa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JSExecutor extends BasePage{
    JavascriptExecutor js;
    public JSExecutor(WebDriver driver) {
        super(driver);
        js = (JavascriptExecutor) driver;
    }


    public JSExecutor enterDataWithJSE(String name, String password) {
        if (name != null && password !=null){
            js.executeScript("document.getElementById('username').value='" + name + "';");
            js.executeScript("document.getElementById('password').value='" + password + "';");
        }
        return this;
    }
}
