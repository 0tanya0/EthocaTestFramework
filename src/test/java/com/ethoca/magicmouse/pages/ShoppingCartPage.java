package com.ethoca.magicmouse.pages;

import com.ethoca.base.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage extends PageObject{
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    //*********Locators*********
    private String proceedToCheckOutBtnByXPath = ".//*[@id='center_column']//a[contains(@title, 'checkout')]";

    public AuthenticationPage clickCheckOut() {
        helperDriver.clickElement(By.xpath(proceedToCheckOutBtnByXPath),5);
        return new AuthenticationPage(driver);
    }
}
