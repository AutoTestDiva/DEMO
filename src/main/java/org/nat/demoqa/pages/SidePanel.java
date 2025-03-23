package org.nat.demoqa.pages;

import org.nat.demoqa.pages.bookStore.BookStorePage;
import org.nat.demoqa.pages.bookStore.LoginPage;
import org.nat.demoqa.pages.bookStore.ProfilePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePanel extends BasePage {

    public SidePanel(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".show #item-0")
    WebElement login;
    public LoginPage selectLogin() {
    clickWithJSExecutor(login, 0, 700);
        return new LoginPage(driver);
    }

    @FindBy(xpath = "//span[.='Profile']")
    WebElement profile;
    public ProfilePage selectProfile() {
        clickWithJSExecutor(profile, 0, 600);
        return new ProfilePage(driver);
    }
}
