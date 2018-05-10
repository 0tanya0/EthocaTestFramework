package com.automationpractice.helpers;

import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.SearchPage;
import com.automationpractice.pages.ShoppingCartPage;
import com.automationpractice.pages.ShoppingDetailsPage;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by 0tanya0 on 5/9/2018.
 */
public class AddToCartHelper {
    public static ShoppingCartPage addItemWithSearch (HomePage homePage, String itemName, String quantity){
        SearchPage searchPage = homePage.searchItem(itemName);
        assertThat(searchPage.isItemFound(itemName))
                .isTrue();

        ShoppingDetailsPage shoppingDetailsPage = searchPage.addToCart();

        ShoppingCartPage shoppingCartPage = shoppingDetailsPage.clickCheckOut();
        assertThat(shoppingCartPage.getItemName())
                .isEqualTo(itemName);
        assertThat(shoppingCartPage.getQuantity())
                .isEqualTo(quantity);
        return shoppingCartPage;
    }


}
