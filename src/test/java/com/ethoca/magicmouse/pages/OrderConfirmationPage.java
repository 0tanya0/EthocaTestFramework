package com.ethoca.magicmouse.pages;

import com.ethoca.base.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage extends PageObject {
    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
    }

    private String orderStatusByXPath= ".//*[@class='cheque-indent']/*";
    private String orderConfirmationPageByClassName= "navigation_page";

    public String getStatusOfOrder() {
        return driverHelper.findElementBy(By.xpath(orderStatusByXPath),2).getText();
    }

    public String getPageName() {
        return driverHelper.findElementToBePresenceBy(By.className(orderConfirmationPageByClassName),2).getText();
    }

}
