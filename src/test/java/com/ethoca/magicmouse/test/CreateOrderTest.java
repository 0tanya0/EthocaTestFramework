package com.ethoca.magicmouse.test;


import com.ethoca.base.BaseTest;
import com.ethoca.base.StringUtils;
import com.ethoca.magicmouse.model.Address;
import com.ethoca.magicmouse.model.PersonalInformation;
import com.ethoca.magicmouse.pages.*;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

/*
STEP 1: Go to http://automationpractice.com. Search item "blouse".
STEP 2: Click "Add to cart" for Blouse item.
STEP 3: Click on “Proceed to checkout” and confirm you have 1 Blouse in your Check-Out Page
STEP 4: Click on “Proceed to checkout” for Blouse item.
STEP 5: Input email and click "Create an Account"
STEP 6: Enter test data needed for account, billing/contact details and click Register
STEP 7: Confirm that user was created and click on “Proceed to checkout”.
STEP 8: Check Agree with Terms and click on “Proceed to checkout”.
STEP 9: Select payment method as Bank wire.
STEP 10: Click on "I confirm my order"
*/

public class CreateOrderTest extends BaseTest {
    @Override
    protected void setup(WebDriver driver) {
        driver.get("http://automationpractice.com");

    }

    @Override
    protected void test(WebDriver driver) {

        logStep("STEP 1: Go to http://automationpractice.com. Search item Blouse.");
        HomePage homePage = new HomePage(driver);

        String itemName = "Blouse";
        String quantity = "1";
        SearchPage searchPage = homePage.searchItem(itemName);
        assertThat(searchPage.isItemFound(itemName))
                .isTrue();

        logStep("STEP 2: Click \"Add to cart\" for Blouse item.");
        ShoppingDetailsPage shoppingDetailsPage = searchPage.addToCart();

        logStep("STEP 3: Click on “Proceed to checkout” and confirm you have 1 Blouse in your Check-Out Page");
        ShoppingCartPage shoppingCartPage = shoppingDetailsPage.clickCheckOut();
        assertThat(shoppingCartPage.getItemName())
                .isEqualTo(itemName);
        assertThat(shoppingCartPage.getQuantity())
                .isEqualTo(quantity);

        logStep("STEP 4: Click on “Proceed to checkout” for Blouse item.");
        AuthenticationPage authenticationPage = shoppingCartPage.clickCheckOut();

        logStep("STEP 5: Input random email and click \"Create an Account\"");
        String randomEmail = StringUtils.generateRandomEmail();
        CreateAccountPage createAccountPage = authenticationPage.inputEmail(randomEmail)
                .clickCreateAccount();

        logStep("STEP 6: Enter test data needed for account, billing/contact details and click Register");
        PersonalInformation personalInformation = new PersonalInformation("Vasya", "Pupkin", "Tanya123!", "416993996");
        Address address = new Address("30 Test", "Toronto", "Colorado", "11223", "United States");

        AddressPage addressPage = createAccountPage.inputPersonalInformation(personalInformation)
                .inputAddress(address)
                .clickRegister();

        logStep("STEP 7: Confirm that user was created and click on “Proceed to checkout”.");
        ShippingPage shippingPage = addressPage.clickCheckOut();
        assertThat(addressPage.getAccountName())
                .isEqualTo(personalInformation.getFirstName()+" "+personalInformation.getLastName());

        logStep("STEP 8: Check Agree with Terms and click on “Proceed to checkout”.");
        PaymentPage paymentPage = shippingPage.checkAgreeTerms().clickCheckOut();

        logStep("STEP 9: Select payment method as Bank wire.");
        BankWirePaymentPage bankWirePaymentPage = paymentPage.selectPaymentMethod("wire");

        logStep("STEP 10: Click on \"I confirm my order\".");
        OrderConfirmationPage orderConfirmationPage = bankWirePaymentPage.clickConfirmOrder();
        assertThat(orderConfirmationPage.getPageName())
                .isEqualTo("Order confirmation");
        assertThat(orderConfirmationPage.getStatusOfOrder())
                .isEqualTo("Your order on My Store is complete.");

    }
}
