package com.ethoca.magicmouse.pages;

import com.ethoca.base.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressPage extends PageObject {
    public AddressPage(WebDriver driver) {
        super(driver);
    }

    //*********Locators*********
    private String proceedToCheckOutBtnByName = "processAddress";
    private String accountValueByXPtah= ".//*[@class='account']/span";


    public ShippingPage clickCheckOut() {
        driverHelper.clickElement(By.name(proceedToCheckOutBtnByName),5);
        return new ShippingPage(driver);
    }

    public String getAccountName() {
        return driverHelper.findElementBy(By.xpath(accountValueByXPtah),2).getText();
    }
}
