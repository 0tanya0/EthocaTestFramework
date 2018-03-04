package com.ethoca.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverHelper {
    private final WebDriver driver;

    public WebDriverHelper(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findElementBy (By locator, int timeSec){
        WebDriverWait wait = new WebDriverWait(driver, timeSec);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    };

    public WebElement findElementToBePresentBy(By locator, int timeSec){
        WebDriverWait wait = new WebDriverWait(driver, timeSec);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    };

    public void clickElement(By locator, int timeSec) {
        WebElement element = findElementBy(locator,timeSec);
        element.click();
    }

    public void selectDropDownList(By locator, String text) {
        Select selectData = new Select(driver.findElement(locator));
        selectData.selectByVisibleText(text);
    }

    public void inputText(By locator, String text) {
        WebElement element = findElementBy(locator,2);
        element.clear();
        element.sendKeys(text);
    }

    public void selectCheckbox (By locator){
        if (!driver.findElement(locator).isSelected())
        {
            driver.findElement(locator).click();
        }
    }

}
