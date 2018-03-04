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

    protected void clickElement(By locator, int timeSec) {
        WebElement element = findElementBy(locator,timeSec);
        element.click();
    }

    protected void selectDropDownList(By locator, String text) {
        Select selectData = new Select(driver.findElement(locator));
        selectData.selectByVisibleText(text);
    }

    protected void inputText(By locator, String text) {
        WebElement element = findElementBy(locator,2);
        element.clear();
        element.sendKeys(text);
    }

    protected void selectCheckbox (By locator){
        if (!driver.findElement(locator).isSelected())
        {
            driver.findElement(locator).click();
        }
    }





}
