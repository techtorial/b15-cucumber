package com.smartbear.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

public class SmartBearHook {


//    @BeforeAll
//    public void clearCaches(){
//        driver.manage().deleteAllCookies();
//    }
    WebDriver driver=DriverHelper.getDriver();



    @Before
    public void setup(){
        driver.navigate().to(ConfigReader.readProperty("smartbearurl"));
    }

    @After
    public void tearDown(Scenario scenario){
        BrowserUtils.getScreenShotForCucumber(driver,scenario);
      //  driver.quit();
    }
}
