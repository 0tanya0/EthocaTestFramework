package com.ethoca.base;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public abstract class PageObject {
    protected final WebDriver driver;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected WebElement waitUntilElementVisible(By locator, int timeSec){
        WebDriverWait wait = new WebDriverWait(driver, timeSec);
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement findElementBy (By locator, int timeSec){
        WebDriverWait wait = new WebDriverWait(driver, timeSec);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    };

    public WebElement findElementToBePresenceBy(By locator, int timeSec){
        WebDriverWait wait = new WebDriverWait(driver, timeSec);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    };

    protected WebElement clickElement(By locator, int timeSec) {
        WebElement element = findElementBy(locator,timeSec);
        element.click();
        return element;
    }

    //Click Method
    public void click (By elementLocation) {
        driver.findElement(elementLocation).click();
    }

    //Write Text
    public void writeText (By elementLocation, String text) {
        driver.findElement(elementLocation).sendKeys(text);
    }

    //Read Text
    public String readText (By elementLocation) {
        return driver.findElement(elementLocation).getText();
    }





}
