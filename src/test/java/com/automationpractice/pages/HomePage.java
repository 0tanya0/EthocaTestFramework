package com.automationpractice.pages;

import com.automationpractice.base.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;


public class HomePage extends PageObject{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //*********Locators*********
    private static final String SEARCH_FIELD_BY_ID = "search_query_top";
    private static final String SEARCH_BTN_BY_NAME = "submit_search";

    public SearchPage searchItem(String itemName) {

        driverHelper.inputText(By.id(SEARCH_FIELD_BY_ID),itemName);
        driverHelper.clickElement(By.name(SEARCH_BTN_BY_NAME),5);
        return new SearchPage(driver);
    }




}
