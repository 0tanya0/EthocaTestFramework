package com.ethoca.magicmouse.pages;

import com.ethoca.base.PageObject;
import com.ethoca.magicmouse.model.Address;
import com.ethoca.magicmouse.model.PersonalInformation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccountPage extends PageObject {
    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    //*********Page Variables*********
//    private String dynamicValue = "dynamic";


    //*********Locators*********
    private String firstnameFieldById = "customer_firstname";
    private String lastnameFieldById = "customer_lastname";
    private String passFieldById = "passwd";
    private String phoneFieldById = "phone_mobile";

    private String addressLineFieldById = "address1";
    private String cityFieldById = "city";
    private String stateFieldById = "id_state";
    private String codeFieldById = "postcode";
    private String countryFieldById = "id_country";

    private String registerBtnById = "submitAccount";


    public CreateAccountPage inputPersonalInformation(PersonalInformation personalInformation) {

        helperDriver.inputText(By.id(firstnameFieldById), personalInformation.getFirstname());
        helperDriver.inputText(By.id(lastnameFieldById), personalInformation.getLastname());
        helperDriver.inputText(By.id(passFieldById), personalInformation.getPassword());
        helperDriver.inputText(By.id(phoneFieldById), personalInformation.getPhoneNumber());

        return this;
    }

    public CreateAccountPage inputAddress(Address address) {
        helperDriver.inputText(By.id(addressLineFieldById), address.getAddressLine());
        helperDriver.inputText(By.id(cityFieldById), address.getCity());
        helperDriver.selectDropDownList(By.id(stateFieldById), address.getState());
        helperDriver.inputText(By.id(codeFieldById), address.getCode());
        helperDriver.selectDropDownList(By.id(countryFieldById), address.getCountry());

        return this;
    }

    public AddressPage clickRegister() {
        helperDriver.clickElement(By.id(registerBtnById),2);

        return new AddressPage(driver);
    }
}
