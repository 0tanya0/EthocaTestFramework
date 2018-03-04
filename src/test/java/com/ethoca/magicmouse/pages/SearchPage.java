package com.ethoca.magicmouse.pages;

import com.ethoca.base.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SearchPage extends PageObject{

    public SearchPage(WebDriver driver, String itemName) {
        super(driver);

    }

    //*********Page Variables*********
    private String dynamicValue = "dynamic";


    //*********Locators*********
    private String itemByXPath = "//*[@class='right-block']//a[@title='"+dynamicValue+"']";
    private String addToCartBtnByCss = ".button.ajax_add_to_cart_button.btn.btn-default>span";
    private String productElementByCss = ".product-container";


    public ShoppingDetailsPage addToCart() {
        WebElement productElement = driverHelper.findElementBy(By.cssSelector(productElementByCss),5);
        new Actions(driver).moveToElement(productElement).perform();
        WebElement addToCartBtn = productElement.findElement(By.cssSelector(addToCartBtnByCss));
        addToCartBtn.click();
        return new ShoppingDetailsPage(driver);
    }

     public boolean isItemFound(String itemName) {
         driverHelper.findElementBy(By.xpath(itemByXPath.replaceFirst(dynamicValue,itemName)), 5);
         return true;
    }
}
