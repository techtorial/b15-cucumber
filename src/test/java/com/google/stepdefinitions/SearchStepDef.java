package com.google.stepdefinitions;

import com.google.pages.GoogleMainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.ConfigReader;
import utils.DriverHelper;

public class SearchStepDef {
    WebDriver driver= DriverHelper.getDriver();
    GoogleMainPage googleMainPage=new GoogleMainPage(driver);
    @Given("User navigates to the Google")
    public void user_navigates_to_the_google() {
        driver.get(ConfigReader.readProperty("googleurl"));
    }
    @When("User searches for Codefish")
    public void user_searches_for_codefish() {
    googleMainPage.validateHappySearch("CodeFish");
    }
    @Then("User gets more than ten links on the first page")
    public void user_gets_more_than_ten_links_on_the_first_page() {
        Assert.assertTrue(googleMainPage.validateNumberOfLinks(10));
    }

    @When("User searches for Kyrgyz Food in USA")
    public void user_searches_for_kyrgyz_food_in_usa() {
    googleMainPage.validateHappySearch("Kyrgyz Food in USA");
    }
    @Then("User validates the result")
    public void user_validates_the_result() {
    Assert.assertTrue(googleMainPage.validateResultFromSearch(100000));
    }

    @When("User searches for Turkish Baklava")
    public void user_searches_for_turkish_baklava() {
    googleMainPage.validateHappySearch("Turkish Baklava");
    }
    @Then("User validates search is done less than one second")
    public void user_validates_search_is_done_less_than_one_second() {

    }
}
