package com.codecool.swaglabstestautomationprojectbrreka.pages;

import com.codecool.swaglabstestautomationprojectbrreka.util.WebdriverClass;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class CheckoutInfoPage {

    private final WebDriver driver = WebdriverClass.getInstance();
    @FindBy(xpath = "//span[text()='Checkout: Your Information']")
    private WebElement checkoutInfoPageTitle;

    @FindBy(xpath = "//button[@id='cancel']")
    private WebElement cancelBtn;

    @FindBy(xpath = "//input[@id='continue']")
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
        return checkoutInfoPageTitle.getText();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public void enterFirstName(String firstNameString) {
        firstNameField.sendKeys(firstNameString);
    }

    public void enterLastName(String lastNameString) {
        lastNameField.sendKeys(lastNameString);
    }

    public void enterPostalCode(String postalCodeString) {
        zipCodeField.sendKeys(postalCodeString);
    }

    public void clickContinueBtn() {
        continueBtn.click();
    }

    public void clickCancelBtn() {
        cancelBtn.click();
    }

    public void checkoutSuccessfully(String firstNameString, String lastNameString, String postalCodeString) {
        enterFirstName(firstNameString);
        enterLastName(lastNameString);
        enterPostalCode(postalCodeString);
        clickContinueBtn();
    }

}
