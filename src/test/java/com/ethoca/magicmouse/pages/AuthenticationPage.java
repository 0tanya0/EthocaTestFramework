package com.ethoca.magicmouse.pages;

import com.ethoca.base.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthenticationPage extends PageObject {
    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    //*********Locators*********
    private static final String EMAIL_FIELD_BY_ID = "email_create";
    private static final String SUBMIT_CREATE_BTN_BY_ID = "SubmitCreate";


    public AuthenticationPage inputEmail(String email) {
        driverHelper.inputText(By.id(EMAIL_FIELD_BY_ID),email);
        return this;
    }

    public CreateAccountPage clickCreateAccount() {
        driverHelper.clickElement(By.id(SUBMIT_CREATE_BTN_BY_ID),2);
        return new CreateAccountPage(driver);
    }
}
