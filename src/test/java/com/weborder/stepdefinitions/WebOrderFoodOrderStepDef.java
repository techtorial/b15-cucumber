package com.weborder.stepdefinitions;

import com.weborder.pages.WebOrderFoodOrderPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class WebOrderFoodOrderStepDef {
    WebDriver driver= DriverHelper.getDriver();
    WebOrderFoodOrderPage webOrderFoodOrderPage=new WebOrderFoodOrderPage(driver);

    @When("User clicks Group Order Box and Next Button")
    public void user_clicks_group_order_box_and_next_button() throws InterruptedException {
    webOrderFoodOrderPage.clickGroupOrderAndNextButton();
    }
    @When("User sends the word {string} for note to the Invitees Section")
    public void user_sends_the_word_for_note_to_the_invitees_section(String note) throws InterruptedException {
    webOrderFoodOrderPage.sendNoteToInvitees(note);
    }
    @When("User sends e-mail address which are {string} and {string} to the Invite List")
    public void user_sends_e_mail_address_which_are_and_to_the_invite_list(String email1, String email2) throws InterruptedException {
    webOrderFoodOrderPage.sendInviteList(email1,email2);
    }
    @When("User chooses the delivery address {string} and validates the address {string}")
    public void user_chooses_the_delivery_address_and_validates_the_address(String deliveryOption, String address) throws InterruptedException {
    webOrderFoodOrderPage.ChooseAndValidateLocation(deliveryOption,address);
    }
    @When("User clicks the create Group Order Button")
    public void user_clicks_the_create_group_order_button() throws InterruptedException {
    webOrderFoodOrderPage.clickGroupOrderButton();
    }
    @Then("User validates the header of page {string}")
    public void user_validates_the_header_of_page(String expectedHeader) throws InterruptedException {
        Assert.assertEquals(expectedHeader,webOrderFoodOrderPage.actualHeader());
    }







}
