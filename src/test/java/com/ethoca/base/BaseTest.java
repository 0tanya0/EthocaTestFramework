package com.ethoca.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    private WebDriver driver;

    protected abstract void setup(WebDriver driver);

    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser) throws Exception {
        //Check if parameter passed from TestNG is 'firefox'
        if(browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }
        //Check if parameter passed as 'chrome'
        else if(browser.equalsIgnoreCase("chrome")){
            //create chrome instance
            driver = new ChromeDriver();
        }
        //Check if parameter passed as 'Edge'
        else if(browser.equalsIgnoreCase("Edge")){
            //set path to Edge.exe
            System.setProperty("webdriver.edge.driver",".\\MicrosoftWebDriver.exe");
            //create Edge instance
            driver = new EdgeDriver();
        }
        else{
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        setup(driver);
        //Maximize Window
        driver.manage().window().maximize();
    }

    protected abstract void test(WebDriver driver);

    @Test
    public void test() {
        test(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
