package org.nat.demoqa.pages;

import org.nat.demoqa.pages.alertsFramesWindows.FramesPage;
import org.nat.demoqa.pages.alertsFramesWindows.NestedFramesPage;
import org.nat.demoqa.pages.bookStore.BookStorePage;
import org.nat.demoqa.pages.bookStore.LoginPage;
import org.nat.demoqa.pages.bookStore.ProfilePage;
import org.nat.demoqa.pages.elements.*;
import org.nat.demoqa.pages.form.PracticeFormPage;
import org.nat.demoqa.pages.interactions.DroppablePage;
import org.nat.demoqa.pages.widgets.*;
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

    @FindBy(xpath = "//span[.='Frames']")
    WebElement frames;

    public FramesPage selectFrames() {
        clickWithJSExecutor(frames, 0, 500);
        return new FramesPage(driver);
    }

    @FindBy(xpath = "//span[.='Nested Frames']")
    WebElement nestedFrames;

    public NestedFramesPage selectNestedFrames() {
        clickWithJSExecutor(nestedFrames, 0, 500);
        return new NestedFramesPage(driver);
    }

    @FindBy(xpath = "//span[.='Buttons']")
    WebElement buttons;

    public ButtonsPage selectButtons() {
        clickWithJSExecutor(buttons,0,500);
        return new ButtonsPage(driver);
    }

    @FindBy(xpath = "//span[.='Auto Complete']")
    WebElement autoComplete;
    public AutoCompletePage selectAutoComplete() {
        clickWithJSExecutor(autoComplete,0,500);
        return new AutoCompletePage(driver);
    }

    @FindBy(xpath = "//span[.='Slider']")
    WebElement slider;
    public SliderPage selectSlider() {
        clickWithJSExecutor(slider,0,700);
        return new SliderPage(driver);
    }

    @FindBy(xpath = "//span[.='Menu']")
    WebElement menu;
    public MenuPage selectMenu() {
        clickWithJSExecutor(menu,0,700);
        return new MenuPage(driver);
    }

    @FindBy(xpath = "//span[.='Select Menu']")
    WebElement selectMenu;

    public SelectMenuPage selectSelectMenu() {
        clickWithJSExecutor(selectMenu, 0, 700);
        return new SelectMenuPage(driver);
    }

    @FindBy(xpath = "//span[.='Practice Form']")
    WebElement practiceForm;
    public PracticeFormPage selectPracticeForm() {
        clickWithJSExecutor(practiceForm,0,500);
        return new PracticeFormPage(driver);
    }

    @FindBy(xpath = "//span[.='Tool Tips']")
    WebElement toolTips;
    public ToolTipsPage selectToolTips() {
    clickWithJSExecutor(toolTips,0, 700);
        return new ToolTipsPage(driver);
    }


    @FindBy(xpath = "//span[.='Droppable']")
    WebElement droppable;
    public DroppablePage selectDroppable() {
        clickWithJSExecutor(droppable,0, 700);
        return new DroppablePage(driver);
    }

    @FindBy(xpath = "//span[.='Text Box']")
    WebElement textBox;
    public TextBoxPage selectTextBox() {
        clickWithJSExecutor(textBox,0, 500);
        return new TextBoxPage(driver);
    }

    @FindBy(xpath = "//span[.='Upload and Download']")
    WebElement upload;
    public UploadPage selectUpload() {
        clickWithJSExecutor(upload,0, 500);
        return new UploadPage(driver);
    }
}
