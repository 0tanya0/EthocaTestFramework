package com.ethoca.magicmouse.pages;

import com.ethoca.base.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthenticationPage extends PageObject {
    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    //*********Page Variables*********
    //String baseURL = "http://automationpractice.com";


    //*********Locators*********
    private static final String emailFieldById = "email_create";
    private static final String submitCreateBtnById = "SubmitCreate";


    public AuthenticationPage inputEmail(String email) {
        driverHelper.inputText(By.id(emailFieldById),email);
        return this;
    }

    public CreateAccountPage clickCreateAccount() {
        driverHelper.clickElement(By.id(submitCreateBtnById),2);
        return new CreateAccountPage(driver);
    }
}
