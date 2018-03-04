package com.ethoca.magicmouse.test;


import com.ethoca.base.BaseTest;
import com.ethoca.base.StringUtils;
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
        AddressPage addressPage = authenticationPage.inputEmail(randomEmail)
                .clickCreateAccount();
        //assert

//        TransactionResultsPage transactionResultsPage = billingDetailsPage.inputContactDetails("test@emai.com")
//                .inputBillingDetails("Visa", "42424242424", 1224)
//                .clickPurchase();
//        assertThat(transactionResultsPage.isOrderCrerated())
//                .isTrue();
    }
}
