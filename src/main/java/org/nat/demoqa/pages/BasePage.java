package org.nat.demoqa.pages;

import org.nat.demoqa.pages.form.PracticeFormPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;

public abstract class BasePage {
    public WebDriver driver;
    JavascriptExecutor js;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
    }

    public void click(WebElement element) {
        element.click();
    }

    public void type(WebElement element, String text) {
        if (text != null) {
            clickWithJSExecutor(element, 0, 600);
            element.clear();
            element.sendKeys(text);
        }
    }

    public void clickWithJSExecutor(WebElement element, int x, int y) {
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
        element.click();
    }

    public void typeWithJSExecutor(WebElement element, String text, int x, int y) {
        if (text != null) {
            clickWithJSExecutor(element, x, y);
            element.clear();
            element.sendKeys(text);
        }
    }

    public boolean shouldHaveText(WebElement element, String text, int time) {
        return new WebDriverWait(driver, Duration.ofSeconds(time))
                .until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public boolean isTextPresent(WebElement element, String book) {
        return element.getText().contains(book);
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void verifyImagesLinks(String linkUrl) {
        try {
            URL url = new URL(linkUrl);
            //create connection and get response status code
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000);
            connection.connect();
            //get response status code
            if (connection.getResponseCode() >= 400) {
                System.out.println(linkUrl + " - " + connection.getResponseMessage() + " is a broken link ");
            } else {
                System.out.println(linkUrl + " - " + connection.getResponseMessage());
            }
        } catch (Exception ex) {
            System.out.println(linkUrl + " - " + ex.getMessage() + " is a broken link");
        }
    }

    public void verifyLinks(String linkUrl, String linkText) {
        try {
            URL url = new URL(linkUrl);
            //create connection and get response status code
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000);
            connection.connect();

            int responseCode = connection.getResponseCode();
            String responseMessage = connection.getResponseMessage();

            //get response status code
            if (responseCode >= 400) {
                System.out.println("Ссылка: \"" + linkText + "\" - " + linkUrl + " - НЕ РАБОТАЕТ (" + responseCode + " " + responseMessage + ")");
            } else {
                System.out.println("Ссылка: \"" + linkText + "\" - " + linkUrl + " - OK (" + responseCode + " " + responseMessage + ")");
            }

        } catch (Exception ex) {
            System.out.println("Ссылка: \"" + linkText + "\" - " + linkUrl + " - ОШИБКА: " + ex.getMessage());
        }

    }
    public void hideIframes() {
        hideAd();       //скрывает рекламу
        hideFooter();   //скрывает footer

    }

     public void hideAd() {          //скрывает рекламу (именно JavascriptExecutor под капотом. Селениум не может это сделать,он под капотом не видит)
        js.executeScript("document.getElementById('adplus-anchor').style.display='none';"); // adplus-anchor - is an element by id
    }
    public void hideFooter() {      //скрывает footer (именно JavascriptExecutor под капотом. Селениум не может это сделать, он под капотом не видит)
        js.executeScript("document.querySelector('footer').style.display='none';");
    }
}
