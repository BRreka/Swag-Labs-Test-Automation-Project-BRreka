package com.codecool.swaglabstestautomationprojectbrreka.pages;

import com.codecool.swaglabstestautomationprojectbrreka.util.WaitClass;
import com.codecool.swaglabstestautomationprojectbrreka.util.WebdriverClass;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import java.util.*;

public class InventoryPage {

    @FindBy(xpath = "//div[@class='app_logo']")
    private WebElement pageTitle;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement shoppingCartLink;

    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private WebElement burgerMenuButton;

    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    private WebElement logOutButton;


    //item links
    @FindBy(xpath = "//div[@text='Sauce Labs Backpack']")
    private WebElement slBackPackLink;

    @FindBy(xpath = "//div[@text='Sauce Labs Bike Light']")
    private WebElement slBikeLightLink;

    @FindBy(xpath = "//div[@text='Sauce Labs Bolt T-Shirt']")
    private WebElement slBoltTShirtLink;

    @FindBy(xpath = "//div[@text='Sauce Labs Fleece Jacket']")
    private WebElement slFleeceJacketLink;

    @FindBy(xpath = "//div[@text='Sauce Labs Onesie']")
    private WebElement slOnesieLink;

    @FindBy(xpath = "//div[@text='Test.allTheThings() T-Shirt (Red)']")
    private WebElement slAllTheThingsTShirtLink;

    //add to cart button per item
    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    private WebElement addBackPackToCartButton;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']")
    private WebElement addBikeLightToCartButton;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")
    private WebElement addBoltTShirtToCartButton;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-fleece-jacket']")
    private WebElement addFleeceJacketToCartButton;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-onesie']")
    private WebElement addOnesieToCartButton;

    @FindBy(xpath = "//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")
    private WebElement addAllTheThingsTShirtToCartButton;


    public InventoryPage() {
        WebDriver driver = WebdriverClass.getInstance();
        PageFactory.initElements(driver,this);
    }

    public String getPageTitleText() {
        return pageTitle.getText();
    }

    public void clickShoppingCart() {
        shoppingCartLink.click();
    }


    //add things to cart separately
    public void addBackpackToCart() {
        addBackPackToCartButton.click();
    }

    public void addBikeLightToCart() {
        addBikeLightToCartButton.click();
    }

    public void addBoltTShirtToCart() {
        addBoltTShirtToCartButton.click();
    }

    public void addFleeceJacketToCart() {
        addFleeceJacketToCartButton.click();
    }

    public void addOnesieToCart() {
        addOnesieToCartButton.click();
    }

    public void addAllTheThingsTShirtToCart() {
        addAllTheThingsTShirtToCartButton.click();
    }

    public void clickHamburgerMenu() {
        burgerMenuButton.click();
    }

    public boolean doesLogoutButtonExist() {
        WaitClass.waitUntilClickable(driver,logOutButton);
        return logOutButton.isDisplayed();
    }

    public void clickLogoutButton() {
        logOutButton.click();
    }

    //add one item to cart
    public void addItemToCartAndClickPay() {
        addBackpackToCart();
        clickShoppingCart();
    }

    //click on logout after everything
    public void clickOnMenuAndLogout() {
        clickHamburgerMenu();
        clickLogoutButton();
    }

}
