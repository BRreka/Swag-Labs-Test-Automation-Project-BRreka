package com.codecool.swaglabstestautomationprojectbrreka.pages;

import com.codecool.swaglabstestautomationprojectbrreka.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class CheckoutInfoPage {

    private final WebDriver driver = WebdriverUtil.getInstance();
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
        WaitUtil.waitUntilVisible(driver, checkoutInfoPageTitle);
        return checkoutInfoPageTitle.getText();
    }

    public String getErrorMessage() {
        WaitUtil.waitUntilVisible(driver, errorMessage);
        return errorMessage.getText();
    }

    public void enterFirstName(String firstNameString) {
        WaitUtil.waitUntilVisible(driver, firstNameField);
        firstNameField.sendKeys(firstNameString);
    }

    public void enterLastName(String lastNameString) {
        WaitUtil.waitUntilVisible(driver, lastNameField);
        lastNameField.sendKeys(lastNameString);
    }

    public void enterPostalCode(String postalCodeString) {
        WaitUtil.waitUntilVisible(driver, zipCodeField);
        zipCodeField.sendKeys(postalCodeString);
    }

    public void clickContinueBtn() {
        //WaitClass.waitUntilClickable(driver, continueBtn);
        continueBtn.click();
    }

    public void clickCancelBtn() {
        WaitUtil.waitUntilClickable(driver, cancelBtn);
        cancelBtn.click();
    }

    public void checkoutSuccessfully(String firstNameString, String lastNameString, String postalCodeString) {
        WaitUtil.waitUntilClickable(driver, continueBtn);
        enterFirstName(firstNameString);
        enterLastName(lastNameString);
        enterPostalCode(postalCodeString);
        clickContinueBtn();
    }

}
