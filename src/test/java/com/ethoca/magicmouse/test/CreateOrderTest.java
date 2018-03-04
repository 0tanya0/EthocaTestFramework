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

        String itemName = "Blouse";
        String quantity = "1";
        SearchPage searchPage = homePage.searchItem(itemName);
        assertThat(searchPage.isItemFound(itemName))
                .isTrue();

        ShoppingDetailsPage shoppingDetailsPage = searchPage.addToCart();

        ShoppingCartPage shoppingCartPage = shoppingDetailsPage.clickCheckOut();
        assertThat(shoppingCartPage.getItemName())
                .isEqualTo(itemName);
        assertThat(shoppingCartPage.getQuintity())
                .isEqualTo(quantity);

        AuthenticationPage authenticationPage = shoppingCartPage.clickCheckOut();

        String randomEmail = StringUtils.generateRandomEmail();
        CreateAccountPage createAccountPage = authenticationPage.inputEmail(randomEmail)
                .clickCreateAccount();

        PersonalInformation personalInformation = new PersonalInformation("Vasya", "Pupkin", "Tanya123!", "416993996");
        Address address = new Address("30 Test", "Toronto", "Colorado", "11223", "United States");

        AddressPage addressPage = createAccountPage.inputPersonalInformation(personalInformation)
                .inputAddress(address)
                .clickRegister();

        ShippingPage shippingPage = addressPage.clickCheckOut();
        assertThat(addressPage.getAccountName())
                .isEqualTo(personalInformation.getFirstname()+" "+personalInformation.getLastname());

        PaymentPage paymentPage = shippingPage.checkAgreeTerms().clickCheckOut();

        BankWirePaymentPage bankWirePaymentPage = paymentPage.selectPaymentMethod("wire");

        OrderConfirmationPage orderConfirmationPage = bankWirePaymentPage.clickConfirmOrder();

        assertThat(orderConfirmationPage.getPageName())
                .isEqualTo("Order confirmation");

        assertThat(orderConfirmationPage.getStatusOfOrder())
                .isEqualTo("Your order on My Store is complete.");

    }
}
