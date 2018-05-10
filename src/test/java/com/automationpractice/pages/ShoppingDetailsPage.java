package com.automationpractice.pages;

import com.automationpractice.base.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingDetailsPage extends PageObject{
    public ShoppingDetailsPage(WebDriver driver) {
        super(driver);
    }

    //*********Locators*********
    private static final String PROCEED_TO_CHECK_OUT_BTN_BY_X_PATH = ".//*[@id='layer_cart']//a[contains(@title, 'checkout')]";



    public ShoppingCartPage clickCheckOut() {
        driverHelper.clickElement(By.xpath(PROCEED_TO_CHECK_OUT_BTN_BY_X_PATH),5);
        return new ShoppingCartPage(driver);
    }



}
