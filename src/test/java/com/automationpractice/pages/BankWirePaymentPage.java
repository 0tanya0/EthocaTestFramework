package com.automationpractice.pages;

import com.automationpractice.base.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BankWirePaymentPage extends PageObject {
    public BankWirePaymentPage(WebDriver driver) {
        super(driver);
    }

    //*********Locators*********
    private static final String CONFIRM_ORDER_BTN_BY_XPATH = ".//*[@id='cart_navigation']/button";

    public OrderConfirmationPage clickConfirmOrder() {
        driverHelper.clickElement(By.xpath(CONFIRM_ORDER_BTN_BY_XPATH),5);

        return new OrderConfirmationPage(driver);
    }
}
