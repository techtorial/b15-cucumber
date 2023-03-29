package com.weborder.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

public class WebOrderHook {

  //  WebDriver driver= DriverHelper.getDriver();

//    @Before//it should be from cucumber
//    public void setup(){
//        driver.get(ConfigReader.readProperty("weborderurl"));
//    }

//    @After
//    public void tearDown(Scenario scenario){
//        BrowserUtils.getScreenShotForCucumber(driver,scenario);
//       driver.quit();
//    }
}
