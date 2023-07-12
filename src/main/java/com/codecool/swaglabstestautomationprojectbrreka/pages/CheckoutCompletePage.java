package com.codecool.swaglabstestautomationprojectbrreka.pages;

import com.codecool.swaglabstestautomationprojectbrreka.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class CheckoutCompletePage {

    private final WebDriver driver = WebdriverUtil.getInstance();
    @FindBy(xpath = "//span[text()='Checkout: Complete!']")
    private WebElement checkoutCompletePageTitle;

    @FindBy(xpath = "//button[@id='back-to-products']")
    private WebElement backHomeBtn;

    @FindBy(xpath = "//h2[@class='complete-header']")
    private WebElement completeHeader;

    @FindBy(xpath = "//div[@class='complete-text']")
    private WebElement completeText;

    public CheckoutCompletePage() {
        PageFactory.initElements(driver,this);
    }

    public String getCheckoutCompletePageTitle() {
        WaitUtil.waitUntilVisible(driver, checkoutCompletePageTitle);
        return checkoutCompletePageTitle.getText();
    }

    public void clickBackHomeBtn() {
        WaitUtil.waitUntilClickable(driver, backHomeBtn);
        backHomeBtn.click();
    }

    public String getCompleteHeaderText() {
        WaitUtil.waitUntilVisible(driver, completeHeader);
        return completeHeader.getText();
    }

    public String getCompleteText() {
        WaitUtil.waitUntilVisible(driver,completeText);
        return completeText.getText();
    }

}
