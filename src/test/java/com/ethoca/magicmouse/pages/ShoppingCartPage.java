package com.ethoca.magicmouse.pages;

import com.ethoca.base.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends PageObject{
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    //*********Locators*********
    private static final String PROCEED_TO_CHECK_OUT_BTN_BY_X_PATH = ".//*[@id='center_column']//a[contains(@title, 'checkout')]";
    private static final String QTY_VALUE_BY_X_PTAH = ".//*[@class='cart_quantity text-center']//input[2]";
    private static final String ITEM_NAME_VALUE_BY_X_PTAH = ".//*[@class='cart_description']/p[@class='product-name']/a";

    public AuthenticationPage clickCheckOut() {
        driverHelper.clickElement(By.xpath(PROCEED_TO_CHECK_OUT_BTN_BY_X_PATH),5);
        return new AuthenticationPage(driver);
    }

    public String getItemName() {
        return driverHelper.findElementBy(By.xpath(ITEM_NAME_VALUE_BY_X_PTAH),2).getText();
    }

    public String getQuantity() {
        return driverHelper.findElementBy(By.xpath(QTY_VALUE_BY_X_PTAH),3).getAttribute("value");
    }
}
