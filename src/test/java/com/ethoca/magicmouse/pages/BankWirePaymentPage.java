package com.ethoca.magicmouse.pages;

import com.ethoca.base.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BankWirePaymentPage extends PageObject {
    public BankWirePaymentPage(WebDriver driver) {
        super(driver);
    }

    //*********Locators*********
    private String confirmOrderBtnByXpath = ".//*[@id='cart_navigation']/button";

    public OrderConfirmationPage clickConfirmOrder() {
        clickElement(By.xpath(confirmOrderBtnByXpath),5);

        return new OrderConfirmationPage(driver);
    }
}
