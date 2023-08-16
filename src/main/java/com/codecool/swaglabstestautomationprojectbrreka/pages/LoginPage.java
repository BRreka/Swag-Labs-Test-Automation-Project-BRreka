package com.codecool.swaglabstestautomationprojectbrreka.pages;

import com.codecool.swaglabstestautomationprojectbrreka.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import java.time.Duration;

public class LoginPage {

    private final WebDriver driver = WebdriverUtil.getInstance();

    @FindBy(xpath = "//input[@name='user-name']")
    private WebElement userNameField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@name='login-button']")
    private WebElement loginButton;

    @FindBy(css = "[data-test='error']")
    private WebElement errorMessage;

    public LoginPage() {
        PageFactory.initElements(driver,this);
    }

    public void manageDriverInit() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
    }

    public void enterUserName(String userNameString) {
        userNameField.sendKeys(userNameString);
    }

    public void enterPassword(String passwordString) {
        passwordField.sendKeys(passwordString);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public boolean doesLoginButtonExist() {
        WaitUtil.waitUntilClickable(driver, loginButton);
        return loginButton.isDisplayed();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    //main method to take care of the whole process on the login page
    public void login(String userNameString, String passwordString) {
        manageDriverInit();
        enterUserName(userNameString);
        enterPassword(passwordString);
        clickLoginButton();
    }
    public void enterUserNameAndPassword(String userNameString, String passwordString) {
        enterUserName(userNameString);
        enterPassword(passwordString);
    }

}
