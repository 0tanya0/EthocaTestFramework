package com.automationpractice.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    protected WebDriver driver;

    protected abstract void setup(WebDriver driver);

    @Parameters ({"browser","server"})
    @BeforeMethod
    public void setUp(String browser, String server) throws Exception {
//        String server = "http://automationpractice.com";
        //Check if parameter passed from TestNG is 'firefox'
        if(browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        //Check if parameter passed as 'chrome'
        else if(browser.equalsIgnoreCase("chrome")){
            //create chrome instance
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        //Check if parameter passed as 'Edge'
        else if(browser.equalsIgnoreCase("Edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        else{
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(server);
//        setup(driver);
        //Maximize Window
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    protected void logStep(String message) {
        Reporter.log(message);
    }
}
