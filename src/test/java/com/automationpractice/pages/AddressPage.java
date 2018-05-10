package com.automationpractice.pages;

import com.automationpractice.base.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressPage extends PageObject {
    public AddressPage(WebDriver driver) {
        super(driver);
    }

    //*********Locators*********
    private static final String PROCEED_TO_CHECK_OUT_BTN_BY_NAME = "processAddress";
    private static final String ACCOUNT_VALUE_BY_X_PTAH = ".//*[@class='account']/span";


    public ShippingPage clickCheckOut() {
        driverHelper.clickElement(By.name(PROCEED_TO_CHECK_OUT_BTN_BY_NAME),5);
        return new ShippingPage(driver);
    }

    public String getAccountName() {
        return driverHelper.findElementBy(By.xpath(ACCOUNT_VALUE_BY_X_PTAH),2).getText();
    }
}
