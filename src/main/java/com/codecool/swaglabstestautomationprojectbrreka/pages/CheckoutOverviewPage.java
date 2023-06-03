package com.codecool.swaglabstestautomationprojectbrreka.pages;

import com.codecool.swaglabstestautomationprojectbrreka.util.WebdriverClass;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class CheckoutOverviewPage {

    @FindBy(xpath = "//span[text()='Checkout: Overview']")
    private WebElement checkoutOverviewPageTitle;

    @FindBy(xpath = "div[@class='inventory_item_name']")
    private WebElement inventoryItemName;

    @FindBy(xpath = "//button[@id='cancel']")
    private WebElement cancelBtn;

    @FindBy(xpath = "//button[@id='finish']")
    private WebElement finishBtn;


    public CheckoutOverviewPage() {
        WebDriver driver = WebdriverClass.getInstance();
        PageFactory.initElements(driver,this);
    }
}
