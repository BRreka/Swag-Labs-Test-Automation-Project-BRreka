package com.codecool.swaglabstestautomationprojectbrreka;

import com.codecool.swaglabstestautomationprojectbrreka.pages.*;
import com.codecool.swaglabstestautomationprojectbrreka.util.InitPropertiesClass;
import org.junit.jupiter.api.*;

import java.util.Properties;


public class LoginTest {
    static LoginPage mainPage;
    static InventoryPage inventoryPage;
    static CartPage cartPage;
    static CheckoutInfoPage checkoutInfoPage;
    static CheckoutCompletePage checkoutCompletePage;
    static CheckoutOverviewPage checkoutOverviewPage;
    static Properties properties;
    @BeforeAll
    public static void setUpAll() {
        mainPage = new LoginPage();
        inventoryPage = new InventoryPage();
        cartPage = new CartPage();
        checkoutInfoPage = new CheckoutInfoPage();
        checkoutCompletePage = new CheckoutCompletePage();
        checkoutOverviewPage = new CheckoutOverviewPage();
        properties = InitPropertiesClass.getInstance();
    }

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void login() {
        mainPage.login(properties.getProperty("standardUserName"), properties.getProperty("password"));
    }

    @AfterEach
    public void tearDown() {
    }
}
