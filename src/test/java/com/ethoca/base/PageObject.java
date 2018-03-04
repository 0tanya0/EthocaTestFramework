package com.ethoca.base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

public abstract class PageObject {
    protected final WebDriver driver;
    protected final HelperWebDriver helperDriver;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        this.helperDriver = new HelperWebDriver(driver);
        PageFactory.initElements(driver, this);
    }
}
