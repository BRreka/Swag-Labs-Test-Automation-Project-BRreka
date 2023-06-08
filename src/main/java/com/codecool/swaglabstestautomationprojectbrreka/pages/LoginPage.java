package com.codecool.swaglabstestautomationprojectbrreka.pages;

import com.codecool.swaglabstestautomationprojectbrreka.util.WaitClass;
import com.codecool.swaglabstestautomationprojectbrreka.util.WebdriverClass;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import java.time.Duration;

public class LoginPage {

    private final WebDriver driver = WebdriverClass.getInstance();

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

    private void manageDriverInit() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
    }

    private void enterUserName(String userNameString) {
        userNameField.sendKeys(userNameString);
    }

    private void enterPassword(String passwordString) {
        passwordField.sendKeys(passwordString);
    }

    private void clickLoginButton() {
        loginButton.click();
    }

    public boolean doesLoginButtonExist() {
        WaitClass.waitUntilClickable(driver, loginButton);
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

}
