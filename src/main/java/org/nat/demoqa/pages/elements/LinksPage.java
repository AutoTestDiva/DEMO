package org.nat.demoqa.pages.elements;

import org.nat.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
        while (iterator.hasNext()) {
            url = iterator.next().getText();
            System.out.println(url);
        }
        return this;
    }

    @FindBy(css = "[href]")
    List<WebElement> attr;

//        public LinksPage checkBrokenLinks() {
//        for (int i = 0; i < allLinks.size(); i++) {
//            WebElement el = allLinks.get(i);
//            String url = el.getDomAttribute("href");
//            verifyLinks(url);
//        }
//        return this;
//    }
    public LinksPage checkBrokenLinks2() {  //you can see names of broken links
        for (WebElement el : allLinks) {
            String linkText = el.getText().trim();
            String url = getValueAttribute(el, "href");

            if (url == null || url.isEmpty()) {
                System.out.println("Link ist without href or empty: \"" + linkText + "\"");
                continue;
            }

            if (url.startsWith("javascript")) {
                System.out.println("Broken JavaScript - link: \"" + linkText + "\" (" + url + ")");
                continue;
            }

            verifyLinks(url, linkText.isEmpty() ? "[without text]" : linkText);
        }
        return this;
    }
}
