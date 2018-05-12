package com.automationpractice.helpers;

import com.automationpractice.base.StringUtils;
import com.automationpractice.model.Address;
import com.automationpractice.model.PersonalInformation;
import com.automationpractice.pages.AddressPage;
import com.automationpractice.pages.AuthenticationPage;
import com.automationpractice.pages.CreateAccountPage;
import com.automationpractice.pages.ShippingPage;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by 0tanya0 on 5/8/2018.
 */
public class AccountHelper {
    public static ShippingPage createUser(AuthenticationPage authenticationPage,
                                          PersonalInformation personalInformation){
        String randomEmail = StringUtils.generateRandomEmail();
        CreateAccountPage createAccountPage = authenticationPage.inputEmail(randomEmail)
                .clickCreateAccount();

        AddressPage addressPage = createAccountPage.inputPersonalInformation(personalInformation)
                .inputAddress(personalInformation.getAddress())
                .clickRegister();

        ShippingPage shippingPage = addressPage.clickCheckOut();
        assertThat(addressPage.getAccountName())
                .isEqualTo(personalInformation.getFirstName()+" "+personalInformation.getLastName());

        return shippingPage;

    }

}
