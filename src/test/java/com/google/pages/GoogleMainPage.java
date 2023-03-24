package com.google.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class GoogleMainPage {

    public GoogleMainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@title='Search']")
    WebElement searchBar;

    @FindBy(xpath= "//a//h3")
    List<WebElement> allLinks;

    @FindBy(xpath = "//div[@id='result-stats']")
    WebElement resultMessage;

    @FindBy(xpath = "//div[@id='result-stats']//nobr")
    WebElement searchTiming;

    public void validateHappySearch(String text){
        searchBar.sendKeys(text, Keys.ENTER);
    }

    public boolean validateNumberOfLinks(int number){
        return (allLinks.size()>number);
    }

    public boolean validateResultFromSearch(int number){
        //About 181,000,000 results (0.67 seconds)  -->181000000
        String[] result=BrowserUtils.getText(resultMessage).split(" ");
        return Double.parseDouble(result[1].replace(",",""))>number;
        //return Long.parselong(result[1].replace(",",""))==181000000
    }

    public boolean validateSearcingTime(){
        String[] time=BrowserUtils.getText(searchTiming).split(" ");
        //(0.67 seconds) --> (0.67    seconds
        return Double.parseDouble(time[0].substring(1))<1.0;
    }














}
