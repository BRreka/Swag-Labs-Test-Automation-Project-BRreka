package com.codecool.swaglabstestautomationprojectbrreka.pages;

import com.codecool.swaglabstestautomationprojectbrreka.util.WaitClass;
import com.codecool.swaglabstestautomationprojectbrreka.util.WebdriverClass;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import java.util.*;

public class InventoryPage {

    private final WebDriver driver = WebdriverClass.getInstance();

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
        PageFactory.initElements(driver,this);
    }

    public String getPageTitleText() {
        WaitClass.waitUntilVisible(driver, pageTitle);
        return pageTitle.getText();
    }

    public void clickShoppingCart() {
        WaitClass.waitUntilClickable(driver, shoppingCartLink);
        shoppingCartLink.click();
    }


    //add things to cart separately
    public void addBackpackToCart() {
        WaitClass.waitUntilClickable(driver,addBackPackToCartButton);
        addBackPackToCartButton.click();
    }

    public void addBikeLightToCart() {
        WaitClass.waitUntilClickable(driver, addBikeLightToCartButton);
        addBikeLightToCartButton.click();
    }

    public void addBoltTShirtToCart() {
        WaitClass.waitUntilClickable(driver, addBoltTShirtToCartButton);
        addBoltTShirtToCartButton.click();
    }

    public void addFleeceJacketToCart() {
        WaitClass.waitUntilClickable(driver, addFleeceJacketToCartButton);
        addFleeceJacketToCartButton.click();
    }

    public void addOnesieToCart() {
        WaitClass.waitUntilClickable(driver, addOnesieToCartButton);
        addOnesieToCartButton.click();
    }

    public void addAllTheThingsTShirtToCart() {
        WaitClass.waitUntilClickable(driver, addAllTheThingsTShirtToCartButton);
        addAllTheThingsTShirtToCartButton.click();
    }

    public void clickHamburgerMenu() {
        WaitClass.waitUntilClickable(driver, burgerMenuButton);
        burgerMenuButton.click();
    }

    public boolean doesLogoutButtonExist() {
        WaitClass.waitUntilVisible(driver,logOutButton);
        return logOutButton.isDisplayed();
    }

    public void clickLogoutButton() {
        WaitClass.waitUntilClickable(driver, logOutButton);
        logOutButton.click();
    }

    //add one item to cart
    public void addBackpackToCartAndClickCart() {
        addBackpackToCart();
        clickShoppingCart();
    }

    public void addAllTheThingsTShirtAndClickCart() {
        addAllTheThingsTShirtToCart();
        clickShoppingCart();
    }

    public void addFleeceJacketAndOnesieAndClickCart() {
        addFleeceJacketToCart();
        addOnesieToCart();
        clickShoppingCart();
    }

    public void addAllItemsAndClickCart() {
        addBackpackToCart();
        addBikeLightToCart();
        addBoltTShirtToCart();
        addFleeceJacketToCart();
        addOnesieToCart();
        addAllTheThingsTShirtToCart();
        clickShoppingCart();
    }
    //click on logout after everything
    public void clickOnMenuAndLogout() {
        clickHamburgerMenu();
        clickLogoutButton();
    }

}
