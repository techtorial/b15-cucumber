package com.smartbear.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class SmartBearOrderPage {

    public SmartBearOrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "select")
    WebElement productDropDown;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_txtQuantity")
    WebElement quantity;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_txtName")
    WebElement customerName;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox2")
    WebElement street;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox3")
    WebElement city;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox4")
    WebElement state;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox5")
    WebElement zipCode;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_cardList_0")
    WebElement visa;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_cardList_1")
    WebElement masterCard;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_cardList_2")
    WebElement americanExpress;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox6")
    WebElement cardNumber;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox1")
    WebElement expireDate;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_InsertButton")
    WebElement processButton;

    @FindBy(tagName = "strong")
    WebElement message;


    public void sendProductInformation(String product, String quantity) throws InterruptedException {
        BrowserUtils.selectBy(productDropDown, product, "text");
        Thread.sleep(5000);
        this.quantity.clear();
        Thread.sleep(2000);
        this.quantity.sendKeys(quantity);
        Thread.sleep(2000);
    }

    public void sendAddressInformation(String customerName, String street, String city, String state, String zipCode) {
        this.customerName.sendKeys(customerName);
        this.street.sendKeys(street);
        this.city.sendKeys(city);
        this.state.sendKeys(state);
        this.zipCode.sendKeys(zipCode);
    }

    public void sendPaymentInformation(String cardType,String cardNumber,String expireDate) {
    selectCard(cardType);
    this.cardNumber.sendKeys(cardNumber);
    this.expireDate.sendKeys(expireDate);
    }

    public void validateMessage(String message) throws InterruptedException {
        processButton.click();
        Thread.sleep(3000);
        Assert.assertEquals(message,BrowserUtils.getText(this.message));
    }

    public void selectCard(String cardType) {
        cardType = cardType.toUpperCase();
        switch (cardType) {

            case "VISA":
                visa.click();
                break;
            case "MASTERCARD":
                masterCard.click();
                break;
            case "AMERICAN EXPRESS":
                americanExpress.click();
                break;
            default:
                System.out.println("Card Type is incorrect,Please check it");
        }
    }


}
