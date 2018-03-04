package com.ethoca.magicmouse.test;


import com.ethoca.base.BaseTest;
import com.ethoca.base.StringUtils;
import com.ethoca.magicmouse.model.Address;
import com.ethoca.magicmouse.model.PersonalInformation;
import com.ethoca.magicmouse.pages.*;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateOrderTest extends BaseTest {
    @Override
    protected void setup(WebDriver driver) {
        driver.get("http://automationpractice.com");

    }

    @Override
    protected void test(WebDriver driver) {

        HomePage homePage = new HomePage(driver);
        SearchPage searchPage = homePage.searchItem("blouse");
        assertThat(searchPage.isItemFound("Blouse"))
                .isTrue();

        ShoppingDetailsPage shoppingDetailsPage = searchPage.addToCart();
        //assert

        ShoppingCartPage shoppingCartPage = shoppingDetailsPage.clickCheckOut();
        //assert

        AuthenticationPage authenticationPage = shoppingCartPage.clickCheckOut();
        //assert

        String randomEmail = StringUtils.generateRandomEmail();
        CreateAccountPage createAccountPage = authenticationPage.inputEmail(randomEmail)
                .clickCreateAccount();
        //assert

        PersonalInformation personalInformation = new PersonalInformation("Vasya", "Pupkin", "Tanya123!", "416993996");
        Address address = new Address("30 Test", "Toronto", "Colorado", "11223", "United States");

        AddressPage addressPage = createAccountPage.inputPersonalInformation(personalInformation)
                .inputAddress(address)
                .clickRegister();
        //assert

        ShippingPage shippingPage = addressPage.clickCheckOut();
        //assert

        PaymentPage paymentPage = shippingPage.checkAgreeTerms().clickCheckOut();

        BankWirePaymentPage bankWirePaymentPage = paymentPage.selectPaymentMethod("wire");

        OrderConfirmationPage orderConfirmationPage = bankWirePaymentPage.clickConfirmOrder();

//        assertThat(bankWirePaymentPage.isOrderCrerated())
//                .isTrue();
    }
}
