package com.smartbear.stepdefinitions;

import com.smartbear.pages.SmartBearLoginPage;
import com.smartbear.pages.SmartBearMainPage;
import com.smartbear.pages.SmartBearOrderPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class ProductCreationStepDef {

    WebDriver driver= DriverHelper.getDriver();
    SmartBearLoginPage loginPage=new SmartBearLoginPage(driver);
    SmartBearMainPage mainPage=new SmartBearMainPage(driver);
    SmartBearOrderPage smartBearOrderPage=new SmartBearOrderPage(driver);

    @Given("User provides username, password and click Order Button")
    public void user_provides_username_password_and_click_order_button() {
        loginPage.login(ConfigReader.readProperty("smartbearusername"),ConfigReader.readProperty("smartbearpassword"));
        mainPage.clickOrderButton();
    }
    @When("User provides the {string},{string} for product information")
    public void user_provides_the_for_product_information(String product, String quantity) throws InterruptedException {
        smartBearOrderPage.sendProductInformation(product,quantity);
    }
    @When("User provides {string},{string},{string},{string},{string} for address information")
    public void user_provides_for_address_information(String name, String street, String city, String state, String zipCode) {
        smartBearOrderPage.sendAddressInformation(name,street,city,state,zipCode);
    }
    @When("User provides {string},{string},{string} for payment information")
    public void user_provides_for_payment_information(String cardType, String cardNumber, String expireDate) {
        smartBearOrderPage.sendPaymentInformation(cardType,cardNumber,expireDate);
    }
    @Then("User clicks process button and validate {string}")
    public void user_clicks_process_button_and_validate(String expectedMessage) throws InterruptedException {
        smartBearOrderPage.validateMessage(expectedMessage);
    }
    @Then("User validates all information {string},{string},{string},{string},{string},{string},{string}{string}{string},{string} from table")
    public void user_validates_all_information_from_table(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10) {

    }
}
