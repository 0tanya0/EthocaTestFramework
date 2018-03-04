package com.ethoca.magicmouse.pages;

import com.ethoca.base.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SearchPage extends PageObject{

    public SearchPage(WebDriver driver) {
        super(driver);

    }

    //*********Page Variables*********
    private static final String DYNAMIC_VALUE = "dynamic";


    //*********Locators*********
    private String itemByXPath = "//*[@class='right-block']//a[@title='"+ DYNAMIC_VALUE +"']";
    private static final String ADD_TO_CART_BTN_BY_CSS = ".button.ajax_add_to_cart_button.btn.btn-default>span";
    private static final String PRODUCT_ELEMENT_BY_CSS = ".product-container";


    public ShoppingDetailsPage addToCart() {
        WebElement productElement = driverHelper.findElementBy(By.cssSelector(PRODUCT_ELEMENT_BY_CSS),5);
        new Actions(driver).moveToElement(productElement).perform();
        WebElement addToCartBtn = productElement.findElement(By.cssSelector(ADD_TO_CART_BTN_BY_CSS));
        addToCartBtn.click();
        return new ShoppingDetailsPage(driver);
    }

     public boolean isItemFound(String itemName) {
         driverHelper.findElementBy(By.xpath(itemByXPath.replaceFirst(DYNAMIC_VALUE,itemName)), 5);
         return true;
    }
}
