package com.automationpractice.pages;

import com.automationpractice.base.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShippingPage extends PageObject {
    public ShippingPage(WebDriver driver) {
        super(driver);
    }

    //*********Locators*********
    private static final String PROCEED_TO_CHECK_OUT_BTN_BY_NAME = "processCarrier";
    private static final String AGREE_TERMS_CHECK_BOX_BY_ID = "cgv";

    public PaymentPage clickCheckOut() {
        driverHelper.clickElement(By.name(PROCEED_TO_CHECK_OUT_BTN_BY_NAME),2);
        return new PaymentPage(driver);
    }

    public ShippingPage checkAgreeTerms() {
        driverHelper.selectCheckbox(By.id(AGREE_TERMS_CHECK_BOX_BY_ID));
        return this;
    }
}
