package org.nat.demoqa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JSExecutor extends BasePage {
    JavascriptExecutor js;

    public JSExecutor(WebDriver driver) {
        super(driver);
        js = (JavascriptExecutor) driver;
    }


    public JSExecutor enterDataWithJSE(String name, String password) {
        if (name != null && password != null) {
            js.executeScript("document.getElementById('username').value='" + name + "';");
            js.executeScript("document.getElementById('password').value='" + password + "';");
            js.executeScript("document.getElementById('password').style.border='3px solid red';"); //you can see field of problem
        }
        return this;
    }

    public JSExecutor clickOnLoginButtonWithJSE() {
        js.executeScript("document.querySelector('.radius').click();"); //querySelector - method of choice only css-selector
        return this;
    }

    public JSExecutor checkURLWithJSE() {
        String URL = js.executeScript("return document.URL;").toString(); //with this method you can see URL address
        System.out.println("URL of the site: " + URL);
        return this;
    }
}

/*  methods of JSExecutor:

 update(refresh) page method:   "history.go(0);"
 check all text on page:     "return document.documentElement.innerText;"
 navigate to new page:  "window.location = 'https://demoqa.com';"
 check title of page:   "return document.title;"
*/