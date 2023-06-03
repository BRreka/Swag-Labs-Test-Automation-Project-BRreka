package com.codecool.swaglabstestautomationprojectbrreka.pages;

import com.codecool.swaglabstestautomationprojectbrreka.util.WebdriverClass;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class CheckoutCompletePage {

    @FindBy(xpath = "//span[text()='Checkout: Complete!']")
    private WebElement checkoutCompletePageTitle;

    @FindBy(xpath = "//button[@id='back-to-products']")
    private WebElement backHomeBtn;

    @FindBy(xpath = "//h2[@class='complete-header']")
    private WebElement completeHeader;

    @FindBy(xpath = "//div[@class='complete-text']")
    private WebElement completeText;

    public CheckoutCompletePage() {
        WebDriver driver = WebdriverClass.getInstance();
        PageFactory.initElements(driver,this);
    }
}
