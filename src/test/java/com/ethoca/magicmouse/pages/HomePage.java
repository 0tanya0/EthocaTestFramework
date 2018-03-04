package com.ethoca.magicmouse.pages;

import com.ethoca.base.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;


public class HomePage extends PageObject{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //*********Page Variables*********
    String baseURL = "http://automationpractice.com";


    //*********Locators*********
    private String searchFieldById = "search_query_top";
    private String searchBtnByName = "submit_search";

    public SearchPage searchItem(String itemName) {

        driverHelper.inputText(By.id(searchFieldById),itemName);
        driverHelper.clickElement(By.name(searchBtnByName),5);
        return new SearchPage(driver, itemName);
    }




}
