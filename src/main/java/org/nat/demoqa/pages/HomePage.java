package org.nat.demoqa.pages;

import org.nat.demoqa.pages.elements.LinksPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

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

    @FindBy(css = ".top-card:nth-child(1)")
    WebElement elements;
    public SidePanel getElements() {
        clickWithJSExecutor(elements, 0,500);
        return new SidePanel(driver);
    }

    @FindBy(css = ".top-card:nth-child(3)")
    WebElement alertsFramesWindows;
    public SidePanel getAlertsFramesWindows() {
        clickWithJSExecutor(alertsFramesWindows,0,400);
        return new SidePanel(driver);
    }

    @FindBy(css = ".top-card:nth-child(4)")
    WebElement widgets;
    public SidePanel getWidgets() {
        clickWithJSExecutor(widgets,0,600);
        return new SidePanel(driver);
    }

    public String getValueAttribute(WebElement element, String name) {
        return element.getDomAttribute(name);
    }

    @FindBy(css = ".top-card:nth-child(2)")
    WebElement forms;
    public SidePanel getForms() {
        clickWithJSExecutor(forms,0,500);
        return new SidePanel(driver);
    }
}
