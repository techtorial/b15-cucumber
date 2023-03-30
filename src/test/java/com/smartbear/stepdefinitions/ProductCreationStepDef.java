package com.smartbear.stepdefinitions;

import com.smartbear.pages.SmartBearLoginPage;
import com.smartbear.pages.SmartBearMainPage;
import com.smartbear.pages.SmartBearOrderPage;
import com.smartbear.pages.SmartBearViewAllOrderPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

import java.util.List;
import java.util.Map;

public class ProductCreationStepDef {

    WebDriver driver= DriverHelper.getDriver();
    SmartBearLoginPage loginPage=new SmartBearLoginPage(driver);
    SmartBearMainPage mainPage=new SmartBearMainPage(driver);
    SmartBearOrderPage smartBearOrderPage=new SmartBearOrderPage(driver);

    SmartBearViewAllOrderPage smartBearViewAllOrderPage=new SmartBearViewAllOrderPage(driver);

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

    @Then("User validates all information {string},{string},{string},{string},{string},{string},{string},{string},{string},{string} from table")
    public void user_validates_all_information_from_table(String name, String product, String quantity, String street, String city, String state, String zipCode, String cardType, String cardNumber, String expiredate) {
        mainPage.viewAllOrdersButton();
        smartBearViewAllOrderPage.validateInformationFromTable(name,product,quantity,street,city,state,zipCode,cardType,cardNumber,expiredate);
    }

    @When("User provides the product,quantity for product information")
    public void user_provides_the_product_quantity_for_product_information(DataTable dataTable) throws InterruptedException {
      Map<String,String> productInformation=dataTable.asMap();
      //  System.out.println(productInformation); //product=MyMoney,quantity=4
        smartBearOrderPage.sendProductInformation(productInformation.get("product"),productInformation.get("quantity"));
    }
    @When("User provides name,street,city,state,zip for address information")
    public void user_provides_name_street_city_state_zip_for_address_information(DataTable dataTable) {
        Map<String,String> addressInformation=dataTable.asMap();
     smartBearOrderPage.sendAddressInformation(addressInformation.get("name"),
                                               addressInformation.get("street"),
                                               addressInformation.get("city"),
                                               addressInformation.get("state"),
                                               addressInformation.get("zip"));
    }
    @When("User provides cardType,cardNumber,expirationDate for payment information")
    public void user_provides_card_type_card_number_expiration_date_for_payment_information(DataTable dataTable) {

        Map<String,String> paymentInformation=dataTable.asMap();

        smartBearOrderPage.sendPaymentInformation(paymentInformation.get("cardType"),
                                                  paymentInformation.get("cardNumber"),
                                                  paymentInformation.get("expirationDate"));
    }

    @Then("User clicks process button and validate message")
    public void user_clicks_process_button_and_validate_message(DataTable dataTable) throws InterruptedException {
       List<String> message= dataTable.asList();
        smartBearOrderPage.validateMessage(message.get(0));
    }



}
