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

        driverHelper.inputText(By.id(firstnameFieldById), personalInformation.getFirstname());
        driverHelper.inputText(By.id(lastnameFieldById), personalInformation.getLastname());
        driverHelper.inputText(By.id(passFieldById), personalInformation.getPassword());
        driverHelper.inputText(By.id(phoneFieldById), personalInformation.getPhoneNumber());

        return this;
    }

    public CreateAccountPage inputAddress(Address address) {
        driverHelper.inputText(By.id(addressLineFieldById), address.getAddressLine());
        driverHelper.inputText(By.id(cityFieldById), address.getCity());
        driverHelper.selectDropDownList(By.id(stateFieldById), address.getState());
        driverHelper.inputText(By.id(codeFieldById), address.getCode());
        driverHelper.selectDropDownList(By.id(countryFieldById), address.getCountry());

        return this;
    }

    public AddressPage clickRegister() {
        driverHelper.clickElement(By.id(registerBtnById),2);

        return new AddressPage(driver);
    }
}
