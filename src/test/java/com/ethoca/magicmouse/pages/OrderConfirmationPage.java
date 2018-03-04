package com.ethoca.magicmouse.pages;

import com.ethoca.base.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage extends PageObject {
    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
    }

    private static final String ORDER_STATUS_BY_X_PATH = ".//*[@class='cheque-indent']/*";
    private static final String ORDER_CONFIRMATION_PAGE_BY_CLASS_NAME = "navigation_page";

    public String getStatusOfOrder() {
        return driverHelper.findElementBy(By.xpath(ORDER_STATUS_BY_X_PATH),2).getText();
    }

    public String getPageName() {
        return driverHelper.findElementToBePresentBy(By.className(ORDER_CONFIRMATION_PAGE_BY_CLASS_NAME),2).getText();
    }

}
