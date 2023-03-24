package com.weborder.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class WebOrderLoginPage {

    public WebOrderLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#Email")
    WebElement username;

    @FindBy(css = "#Password")
    WebElement password;

    @FindBy(xpath = "//button[.='Sign In']")
    WebElement signInButton;

    @FindBy(xpath = "//div[contains(text(),'Sign in Failed')]")
    WebElement errorMessage;


    public void webOrderLogin(String username,String password){
        this.username.clear();
        this.username.sendKeys(username);
        this.password.clear();
        this.password.sendKeys(password);
        signInButton.click();
    }

    public String validateErrorMessage(){
        return BrowserUtils.getText(errorMessage);
    }

}
