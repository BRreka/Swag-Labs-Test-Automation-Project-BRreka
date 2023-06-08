package com.codecool.swaglabstestautomationprojectbrreka.pages;

import com.codecool.swaglabstestautomationprojectbrreka.util.WaitClass;
import com.codecool.swaglabstestautomationprojectbrreka.util.WebdriverClass;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import java.util.*;

public class CartPage {

    private final WebDriver driver = WebdriverClass.getInstance();
    @FindBy(xpath = "//span[text()='Your Cart']")
    private WebElement yourCartTitle;

    @FindBy(xpath = "//button[@id='continue-shopping']")
    private WebElement continueShoppingBtn;

    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement checkoutBtn;

    @FindBy(xpath = "//button[text()='Remove']")
    private List<WebElement> removeBtnList;

    public CartPage() {
        PageFactory.initElements(driver,this);
    }

    public String getCartTitle() {
        WaitClass.waitUntilVisible(driver, yourCartTitle);
        return yourCartTitle.getText();
    }

    public void clickContinueShopping() {
        WaitClass.waitUntilClickable(driver, continueShoppingBtn);
        continueShoppingBtn.click();
    }

    public void clickCheckoutBtn() {
        WaitClass.waitUntilClickable(driver, checkoutBtn);
        checkoutBtn.click();
    }

    public void clickRemoveBtn(String elementToRemove) {
        WebElement removeThis = removeBtnList.stream().filter(element -> elementToRemove.equals(element.getText())).findFirst().orElseThrow();
        removeThis.click();
    }

}
