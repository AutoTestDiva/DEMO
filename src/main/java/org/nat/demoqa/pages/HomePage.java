package org.nat.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".top-card:nth-child(6)")
    WebElement bookStore;
    public SidePanel getBookStore() {
        clickWithJSExecutor(bookStore, 0, 700);
        return new SidePanel(driver);
    }

    @FindBy(xpath = "//a[.='JavaScript Alerts']")
    WebElement alertsLink;

    public AlertsPage getAlerts(){
        click(alertsLink);
        return new AlertsPage(driver);
    }
}
