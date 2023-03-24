package com.weborder.stepdefinitions;

import com.weborder.pages.WebOrderLoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class WebOrderLoginStepDef {
    WebDriver driver= DriverHelper.getDriver();
    WebOrderLoginPage webOrderLoginPage=new WebOrderLoginPage(driver);
    @When("User provides {string} and {string} for WebOrder")
    public void user_provides_and_for_web_order(String username, String password) {
    webOrderLoginPage.webOrderLogin(username,password);
    }
    @Then("User validates the {string} from homepage")
    public void user_validates_the_from_homepage(String title) {
        Assert.assertEquals(title,driver.getTitle().trim());
    }
    @Then("User validates the {string} error message")
    public void user_validates_the_error_message(String expectedErrorMessage) {
        Assert.assertEquals(expectedErrorMessage,webOrderLoginPage.validateErrorMessage());
    }

}
