package com.ethoca.magicmouse.pages;

import com.ethoca.base.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShippingPage extends PageObject {
    public ShippingPage(WebDriver driver) {
        super(driver);
    }

    //*********Locators*********
    private String proceedToCheckOutBtnByName = "processCarrier";
    private String agreeTermsCheckBoxById = "cgv";

    public PaymentPage clickCheckOut() {
        clickElement(By.name(proceedToCheckOutBtnByName),2);
        return new PaymentPage(driver);
    }

    public ShippingPage checkAgreeTerms() {
        selectCheckbox(By.id(agreeTermsCheckBoxById));
        return this;
    }
}
