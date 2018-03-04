package com.ethoca.magicmouse.pages;

import com.ethoca.base.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingDetailsPage extends PageObject{
    public ShoppingDetailsPage(WebDriver driver) {
        super(driver);
    }

    //*********Page Variables*********
    //private String dynamicValue = "dynamic";


    //*********Locators*********
    private String proceedToCheckOutBtnByXPath = ".//*[@id='layer_cart']//a[contains(@title, 'checkout')]";



    public ShoppingCartPage clickCheckOut() {
        driverHelper.clickElement(By.xpath(proceedToCheckOutBtnByXPath),5);
        return new ShoppingCartPage(driver);
    }



}
