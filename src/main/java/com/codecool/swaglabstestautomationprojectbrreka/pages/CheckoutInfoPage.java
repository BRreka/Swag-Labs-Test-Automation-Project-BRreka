package com.codecool.swaglabstestautomationprojectbrreka.pages;

import com.codecool.swaglabstestautomationprojectbrreka.util.WaitClass;
import com.codecool.swaglabstestautomationprojectbrreka.util.WebdriverClass;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import java.time.Duration;

public class CheckoutInfoPage {

    private final WebDriver driver = WebdriverClass.getInstance();
    @FindBy(xpath = "//span[text()='Checkout: Your Information']")
    private WebElement checkoutInfoPageTitle;

    @FindBy(xpath = "//button[@id='cancel']")
    private WebElement cancelBtn;

    @FindBy(xpath = "//input[@name='continue']")
    private WebElement continueBtn;

    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@id='postal-code']")
    private WebElement zipCodeField;

    @FindBy(xpath = "//h3[text()='Error: First Name is required']")
    private WebElement errorMessage;

    public CheckoutInfoPage() {
        PageFactory.initElements(driver,this);
    }

    public String getCheckoutInfoPageTitle() {
        WaitClass.waitUntilVisible(driver, checkoutInfoPageTitle);
        return checkoutInfoPageTitle.getText();
    }

    public String getErrorMessage() {
        WaitClass.waitUntilVisible(driver, errorMessage);
        return errorMessage.getText();
    }

    public void enterFirstName(String firstNameString) {
        WaitClass.waitUntilVisible(driver, firstNameField);
        firstNameField.sendKeys(firstNameString);
    }

    public void enterLastName(String lastNameString) {
        WaitClass.waitUntilVisible(driver, lastNameField);
        lastNameField.sendKeys(lastNameString);
    }

    public void enterPostalCode(String postalCodeString) {
        WaitClass.waitUntilVisible(driver, zipCodeField);
        zipCodeField.sendKeys(postalCodeString);
    }

    public void clickContinueBtn() {
        //WaitClass.waitUntilClickable(driver, continueBtn);
        continueBtn.click();
    }

    public void clickCancelBtn() {
        WaitClass.waitUntilClickable(driver, cancelBtn);
        cancelBtn.click();
    }

    public void checkoutSuccessfully(String firstNameString, String lastNameString, String postalCodeString) {
        WaitClass.waitUntilClickable(driver, continueBtn);
        enterFirstName(firstNameString);
        enterLastName(lastNameString);
        enterPostalCode(postalCodeString);
        clickContinueBtn();
    }

}
