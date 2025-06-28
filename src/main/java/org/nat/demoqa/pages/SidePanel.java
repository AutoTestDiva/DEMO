package org.nat.demoqa.pages;

import org.nat.demoqa.pages.bookStore.BookStorePage;
import org.nat.demoqa.pages.bookStore.LoginPage;
import org.nat.demoqa.pages.bookStore.ProfilePage;
import org.nat.demoqa.pages.elements.BrokenLinksImagesPage;
import org.nat.demoqa.pages.elements.LinksPage;
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

    @FindBy(xpath = "//span[.='Links']")
    WebElement links;

    public LinksPage selectLinks() {
        clickWithJSExecutor(links, 0, 500);
        return new LinksPage(driver);
    }

    @FindBy(xpath = "//span[.='Broken Links - Images']")
    WebElement brokenLinksImages;

    public BrokenLinksImagesPage selectBrokenLinksImages() {
        clickWithJSExecutor(brokenLinksImages, 0, 600);
        return new BrokenLinksImagesPage(driver);
    }
}
