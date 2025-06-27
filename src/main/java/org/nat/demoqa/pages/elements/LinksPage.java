package org.nat.demoqa.pages.elements;

import org.nat.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.Iterator;
import java.util.List;

public class LinksPage extends BasePage {
    public LinksPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "a")
    List<WebElement> allLinks;
    public LinksPage getAllLinks() {
        System.out.println("Total number of links on the page: " + allLinks.size());
        String url;

        Iterator<WebElement> iterator = allLinks.iterator();
        while (iterator.hasNext()){
            url = iterator.next().getText();
            System.out.println(url);
        }
        return this;
    }

    @FindBy(css = "[href]")
    List<WebElement> attr;
    public LinksPage checkBrokenLinks() {
        for (int i = 0; i<allLinks.size(); i++){
            WebElement el = allLinks.get(i);
            String url = el.getDomAttribute("href");
            verifyLinks(url);
        }
        return this;
    }

    public void verifyLinks(String linkUrl) {
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
    }catch (Exception ex){
        System.out.println(linkUrl + " - " + ex.getMessage() + " is a broken link");
    }
    }
}
