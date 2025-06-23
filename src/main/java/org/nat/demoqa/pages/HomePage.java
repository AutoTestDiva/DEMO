package org.nat.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".top-card:nth-child(6)")
    WebElement bookStore;

    public SidePanel getBookStore() {
        clickWithJSExecutor(bookStore, 0, 700);
        return new SidePanel(driver);
    }

    @FindBy(css = "div:nth-child(3) div:nth-child(1) div:nth-child(3) h5:nth-child(1)")
    WebElement alertsLink;

    public AlertsPage getAlerts() {
        clickWithJSExecutor(alertsLink, 0, 300);
        return new AlertsPage(driver);
    }

    @FindBy(xpath = "//a[.='Multiple Windows']")
    WebElement windowsLink;

    public WindowPage getMultipleWindows() {
        click(windowsLink);
        return new WindowPage(driver);
    }

    @FindBy(xpath = "//a[.='Form Authentication']")
    WebElement formLink;

    public JSExecutor getFormAuthentication() {
        click(formLink);
        return new JSExecutor(driver);
    }
}
