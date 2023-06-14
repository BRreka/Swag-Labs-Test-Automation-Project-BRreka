package com.codecool.swaglabstestautomationprojectbrreka.pages;

import com.codecool.swaglabstestautomationprojectbrreka.util.WaitClass;
import com.codecool.swaglabstestautomationprojectbrreka.util.WebdriverClass;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class CheckoutCompletePage {

    private final WebDriver driver = WebdriverClass.getInstance();
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
        WaitClass.waitUntilVisible(driver, checkoutCompletePageTitle);
        return checkoutCompletePageTitle.getText();
    }

    public void clickBackHomeBtn() {
        WaitClass.waitUntilClickable(driver, backHomeBtn);
        backHomeBtn.click();
    }

    public String getCompleteHeaderText() {
        WaitClass.waitUntilVisible(driver, completeHeader);
        return completeHeader.getText();
    }

    public String getCompleteText() {
        WaitClass.waitUntilVisible(driver,completeText);
        return completeText.getText();
    }

}
