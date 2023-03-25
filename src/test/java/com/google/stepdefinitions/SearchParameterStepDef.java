package com.google.stepdefinitions;

import com.google.pages.GoogleMainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class SearchParameterStepDef {
    WebDriver driver= DriverHelper.getDriver();
    GoogleMainPage googleMainPage=new GoogleMainPage(driver);
    @Given("User navigates to the {string}")
    public void user_navigates_to_the(String url) throws InterruptedException {
        Thread.sleep(3000);
    driver.get(url);
    }
    @When("User searches for {string}")
    public void user_searches_for(String text) {
    googleMainPage.validateHappySearch(text);
    }
    @Then("User gets more than {int} links from first page")
    public void user_gets_more_than_links_from_first_page(int link) {
        Assert.assertTrue(googleMainPage.validateNumberOfLinks(link));
    }
    @Then("User validates the result is more than {int}")
    public void user_validates_the_result_is_more_than(int expectedResult) {
        Assert.assertTrue(googleMainPage.validateResultFromSearch(expectedResult));
    }
}
