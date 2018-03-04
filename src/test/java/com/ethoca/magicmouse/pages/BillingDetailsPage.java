package com.ethoca.magicmouse.pages;

import com.ethoca.base.PageObject;
import org.openqa.selenium.WebDriver;

public class BillingDetailsPage extends PageObject{
    public BillingDetailsPage(WebDriver driver) {
        super(driver);
    }

    public BillingDetailsPage inputContactDetails(String s) {
        // TODO
        return this;
    }

    public BillingDetailsPage inputBillingDetails(String paymentMethod, String cardNumber, int i) {
        // TODO
        return this;
    }

    public TransactionResultsPage clickPurchase() {
        // TODO
        return new TransactionResultsPage(driver);
    }
}
