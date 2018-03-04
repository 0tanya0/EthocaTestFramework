package com.ethoca.base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

public abstract class PageObject {
    protected final WebDriver driver;
    protected final WebDriverHelper driverHelper;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        this.driverHelper = new WebDriverHelper(driver);
        PageFactory.initElements(driver, this);
    }
}
