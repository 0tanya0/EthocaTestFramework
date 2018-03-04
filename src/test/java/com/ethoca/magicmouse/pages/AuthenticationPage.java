package com.ethoca.magicmouse.pages;

import com.ethoca.base.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

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
        WebElement emailField = findElementBy(By.id(emailFieldById),5);
        emailField.sendKeys(email);
        return this;
    }

    public AddressPage clickCreateAccount() {
        WebElement submitCreateBtn = findElementBy(By.id(submitCreateBtnById),5);
        submitCreateBtn.click();
        return new AddressPage(driver);
    }
}
