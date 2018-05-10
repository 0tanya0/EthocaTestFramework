package com.automationpractice.pages;

import com.automationpractice.base.PageObject;
import com.automationpractice.model.Address;
import com.automationpractice.model.PersonalInformation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccountPage extends PageObject {
    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    //*********Locators*********
    private static final String FIRST_NAME_FIELD_BY_ID = "customer_firstname";
    private static final String LAST_NAME_FIELD_BY_ID = "customer_lastname";
    private static final String PASS_FIELD_BY_ID = "passwd";
    private static final String PHONE_FIELD_BY_ID = "phone_mobile";

    private static final String ADDRESS_LINE_FIELD_BY_ID = "address1";
    private static final String CITY_FIELD_BY_ID = "city";
    private static final String STATE_FIELD_BY_ID = "id_state";
    private static final String CODE_FIELD_BY_ID = "postcode";
    private static final String COUNTRY_FIELD_BY_ID = "id_country";

    private static final String REGISTER_BTN_BY_ID = "submitAccount";


    public CreateAccountPage inputPersonalInformation(PersonalInformation personalInformation) {

        driverHelper.inputText(By.id(FIRST_NAME_FIELD_BY_ID), personalInformation.getFirstName());
        driverHelper.inputText(By.id(LAST_NAME_FIELD_BY_ID), personalInformation.getLastName());
        driverHelper.inputText(By.id(PASS_FIELD_BY_ID), personalInformation.getPassword());
        driverHelper.inputText(By.id(PHONE_FIELD_BY_ID), personalInformation.getPhoneNumber());

        return this;
    }

    public CreateAccountPage inputAddress(Address address) {
        driverHelper.inputText(By.id(ADDRESS_LINE_FIELD_BY_ID), address.getAddressLine());
        driverHelper.inputText(By.id(CITY_FIELD_BY_ID), address.getCity());
        driverHelper.selectDropDownList(By.id(STATE_FIELD_BY_ID), address.getState());
        driverHelper.inputText(By.id(CODE_FIELD_BY_ID), address.getCode());
        driverHelper.selectDropDownList(By.id(COUNTRY_FIELD_BY_ID), address.getCountry());

        return this;
    }

    public AddressPage clickRegister() {
        driverHelper.clickElement(By.id(REGISTER_BTN_BY_ID),2);

        return new AddressPage(driver);
    }
}
