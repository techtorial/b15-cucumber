package com.weborder.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class WebOrderFoodOrderPage {

    public WebOrderFoodOrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//label[@for='GroupOrder']")
    WebElement groupOrderButton;

    @FindBy(css = "#getAddressNextButton")
    WebElement nextButton;

    @FindBy(css = "#InviteNote")
    WebElement invitees;

    @FindBy(css = "#InviteList")
    WebElement inviteList;

    @FindBy(css = "#ConfirmAddressID")
    WebElement locationBox;

    @FindBy(css = "#addressPreview")
    WebElement addressOfLocation;

    @FindBy(css = "#createGroupOrder")
    WebElement createGroupOrderButton;

    @FindBy(tagName = "h1")
    WebElement header;

    @FindBy(xpath = "//p[contains(text(),'Your group order')]")
    WebElement paragraph;

    public void clickGroupOrderAndNextButton() throws InterruptedException {
        groupOrderButton.click();
        Thread.sleep(2000);
        nextButton.click();
    }

    public void sendNoteToInvitees(String note) throws InterruptedException {
        Thread.sleep(2000);
        invitees.sendKeys(note);
    }

    public void sendInviteList(String email1,String email2) throws InterruptedException {
        Thread.sleep(2000);
        inviteList.sendKeys(email1 +" , "+ email2);
    }

    public void ChooseAndValidateLocation(String location,String address) throws InterruptedException {
        Thread.sleep(2000);
        BrowserUtils.selectBy(locationBox,location,"text");//My H// ouse
        Assert.assertTrue(BrowserUtils.getText(addressOfLocation).contains(address)); //3137 Lagula
    }

    public void clickGroupOrderButton() throws InterruptedException {
        Thread.sleep(2000);
        createGroupOrderButton.click();
    }

    public String actualHeader() throws InterruptedException {
        Thread.sleep(2000);
        return BrowserUtils.getText(header);
    }

    public boolean validateParagraph(String text){
        return BrowserUtils.getText(paragraph).contains(text);
    }




}
