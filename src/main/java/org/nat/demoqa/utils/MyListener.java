package org.nat.demoqa.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.util.List;
import java.util.Random;

public class MyListener implements WebDriverListener {

    Logger logger = LoggerFactory.getLogger(MyListener.class);      //Logger именно org.slf4j.Logger;

    @Override
    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
        WebDriverListener.super.onError(target, method, args, e);
        logger.info("We have a problem");
        logger.info("Object target --> " + target.toString());
        logger.info("**********************************");
        logger.info("Method name --> " + method.getName() );
        logger.info("**********************************");
        logger.info("InvocationTargetException --> " + e.getTargetException());

        //creating screenshots
        int i = new Random().nextInt(1000)+1000;
        String link = "screenshots/screen_" + i + ".png";
        logger.info("Screen with error --> " + link);
        WebDriver driver = (ChromeDriver) target;
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File tmp = screenshot.getScreenshotAs(OutputType.FILE);
        Files.
    }

    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        WebDriverListener.super.beforeFindElement(driver, locator);
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        WebDriverListener.super.afterFindElement(driver, locator, result);
    }

    @Override
    public void beforeFindElements(WebDriver driver, By locator) {
        WebDriverListener.super.beforeFindElements(driver, locator);
    }

    @Override
    public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
        WebDriverListener.super.afterFindElements(driver, locator, result);
    }
}
