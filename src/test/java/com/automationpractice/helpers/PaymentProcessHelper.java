package com.automationpractice.helpers;

import com.automationpractice.pages.BankWirePaymentPage;
import com.automationpractice.pages.OrderConfirmationPage;
import com.automationpractice.pages.PaymentPage;
import com.automationpractice.pages.ShippingPage;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by 0tanya0 on 5/10/2018.
 */
public class PaymentProcessHelper {
    public static OrderConfirmationPage addPayment (ShippingPage shippingPage, String paymentMethod){
        PaymentPage paymentPage = shippingPage.checkAgreeTerms().clickCheckOut();

        BankWirePaymentPage bankWirePaymentPage = paymentPage.selectPaymentMethod(paymentMethod);

        OrderConfirmationPage orderConfirmationPage = bankWirePaymentPage.clickConfirmOrder();
        assertThat(orderConfirmationPage.getPageName())
                .isEqualTo("Order confirmation");
        assertThat(orderConfirmationPage.getStatusOfOrder())
                .isEqualTo("Your order on My Store is complete.");
        return orderConfirmationPage;
    }
}
