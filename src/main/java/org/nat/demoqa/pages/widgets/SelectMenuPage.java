package org.nat.demoqa.pages.widgets;

import org.nat.demoqa.pages.HomePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectMenuPage extends HomePage {
    public SelectMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "oldSelectMenu")
    WebElement oldSelectMenu;

    public SelectMenuPage selectOldStyle(String color) {
        Select select = new Select(oldSelectMenu);
        select.selectByVisibleText(color);
        System.out.println(select.getFirstSelectedOption().getText() + " is first");
        System.out.println("************************************");
        List<WebElement> options = select.getOptions();
        for (int i = 0; i<options.size(); i++){
            System.out.println(options.get(i).getText());
        }
        return this;
    }

    @FindBy(id = "react-select-4-input")
    WebElement inputSelect;

    @FindBy(css = "html")
    WebElement space;
    public SelectMenuPage multiSelect(String[] colors) {
        pause(1000);
        for (int i=0; i< colors.length; i++){
            if (colors[i]!=null) {
                inputSelect.sendKeys(colors[i]);
                inputSelect.sendKeys(Keys.ENTER);
            }
            click(space);
        }
        return this;
    }
}
