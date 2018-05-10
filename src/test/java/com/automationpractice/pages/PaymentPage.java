package com.automationpractice.pages;

import com.automationpractice.base.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends PageObject {
    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    //*********Page Variables*********
    private static final String DYNAMIC_VALUE = "dynamic";

    //*********Locators*********
    private String bankWireBtnByXPath = ".//*[@id='HOOK_PAYMENT']//a[contains(@title, '"+ DYNAMIC_VALUE +"')]";

    public BankWirePaymentPage selectPaymentMethod(String paymentMethod) {
        driverHelper.clickElement(By.xpath(bankWireBtnByXPath.replaceFirst(DYNAMIC_VALUE,paymentMethod)),5);
        return new BankWirePaymentPage(driver);
    }


}
