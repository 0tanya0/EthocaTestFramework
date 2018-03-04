package com.ethoca.magicmouse.pages;

import com.ethoca.base.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends PageObject {
    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    //*********Page Variables*********
    private String dynamicValue = "dynamic";

    //*********Locators*********
    private String bankWireBtnByXPath = ".//*[@id='HOOK_PAYMENT']//a[contains(@title, '"+dynamicValue+"')]";

    public BankWirePaymentPage selectPaymentMethod(String paymentMethod) {
        driverHelper.clickElement(By.xpath(bankWireBtnByXPath.replaceFirst(dynamicValue,paymentMethod)),5);
        return new BankWirePaymentPage(driver);
    }


}
