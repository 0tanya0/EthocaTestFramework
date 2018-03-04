package com.ethoca.magicmouse.pages;

import com.ethoca.base.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage extends PageObject{
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    //*********Page Variables*********
    //private String dynamicValue = "dynamic";

    //*********Locators*********
    private String proceedToCheckOutBtnByXPath = ".//*[@id='center_column']//a[contains(@title, 'checkout')]";
    private String qtyValueByXPtah= ".//*[@class='cart_quantity text-center']//input[2]";
    private String itemNameValueByXPtah= ".//*[@class='cart_description']/p[@class='product-name']/a";

    public AuthenticationPage clickCheckOut() {
        driverHelper.clickElement(By.xpath(proceedToCheckOutBtnByXPath),5);
        return new AuthenticationPage(driver);
    }

    public String getItemName() {
        return driverHelper.findElementBy(By.xpath(itemNameValueByXPtah),2).getText();
    }

    public String getQuintity() {
        return driverHelper.findElementBy(By.xpath(qtyValueByXPtah),3).getAttribute("value");
    }
}
