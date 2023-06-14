package com.codecool.swaglabstestautomationprojectbrreka.pages;

import com.codecool.swaglabstestautomationprojectbrreka.util.WaitClass;
import com.codecool.swaglabstestautomationprojectbrreka.util.WebdriverClass;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import java.util.*;
import java.util.stream.*;

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

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private List<WebElement> itemList;

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
        int index = getElementNumberToRemove(elementToRemove);
        WebElement removeElement = removeBtnList.get(index);
        removeElement.click();
    }

    private int getElementNumberToRemove(String elementToRemove) {
        return IntStream.range(0, itemList.size())
                .filter(in -> itemList.get(in).getText().equals(elementToRemove))
                .findFirst()
                .orElseThrow();
    }

}
