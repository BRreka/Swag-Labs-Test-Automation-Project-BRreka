package com.codecool.swaglabstestautomationprojectbrreka.pages;

import com.codecool.swaglabstestautomationprojectbrreka.util.WebdriverClass;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import java.util.*;

public class CartPage {

    @FindBy(xpath = "//span[text()='Your Cart']")
    private WebElement yourCartTitle;

    @FindBy(xpath = "//button[@id='continue-shopping']")
    private WebElement continueShoppingBtn;

    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement checkoutBtn;

    @FindBy(xpath = "//button[text()='Remove']")
    private WebElement removeBtn;

    public CartPage() {
        WebDriver driver = WebdriverClass.getInstance();
        PageFactory.initElements(driver,this);
    }

    public String getCartTitle() {
        return yourCartTitle.getText();
    }

    public void clickContinueShopping() {
        continueShoppingBtn.click();
    }

    public void clickCheckoutBtn() {
        checkoutBtn.click();
    }

    public void clickRemoveBtn() {
        removeBtn.click();
    }

}
