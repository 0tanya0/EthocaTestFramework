package com.automationpractice.tests;


import com.automationpractice.base.BaseTest;
import com.automationpractice.base.DataProviderJson;
import com.automationpractice.base.StringUtils;
import com.automationpractice.helpers.AccountHelper;
import com.automationpractice.helpers.AddToCartHelper;
import com.automationpractice.helpers.PaymentProcessHelper;
import com.automationpractice.model.Address;
import com.automationpractice.model.PersonalInformation;
import com.automationpractice.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

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

    }

    @Test(dataProvider = "getUserData", dataProviderClass = DataProviderJson.class)
    public void test(PersonalInformation personalInformation) {
        logStep("STEP 1: Search item Blouse. Click \"Add to cart\" for Blouse item. " +
                "Click on “Proceed to checkout” for Blouse item.");
        String itemName = "Blouse";
        String quantity = "1";
        HomePage homePage = new HomePage(driver);
        ShoppingCartPage shoppingCartPage = AddToCartHelper.addItemWithSearch(homePage,itemName,quantity);

        logStep("STEP 2: Click on “Proceed to checkout” for Blouse item.");
        AuthenticationPage authenticationPage = shoppingCartPage.clickCheckOut();

        logStep("STEP 3: Input random email and click \"Create an Account\"");
        ShippingPage shippingPage = AccountHelper.createUser(authenticationPage,personalInformation);

        logStep("STEP 4: Check Agree with Terms and click on “Proceed to checkout”." +
                "Select payment method as Bank wire");
        String paymentMethod = "wire";
        OrderConfirmationPage orderConfirmationPage = PaymentProcessHelper.addPayment(shippingPage,paymentMethod);
    }


}
