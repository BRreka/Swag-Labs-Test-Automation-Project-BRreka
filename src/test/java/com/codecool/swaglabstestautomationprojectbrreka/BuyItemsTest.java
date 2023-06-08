package com.codecool.swaglabstestautomationprojectbrreka;

import com.codecool.swaglabstestautomationprojectbrreka.pages.*;
import com.codecool.swaglabstestautomationprojectbrreka.util.InitPropertiesClass;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class BuyItemsTest {

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

    @Test
    public void testBuyingSauceLabsBackpackAndLogout() {
        mainPage.login(properties.getProperty("standardUserName"), properties.getProperty("password"));
        assertEquals("Swag Labs", inventoryPage.getPageTitleText());
        inventoryPage.addBackpackToCart();
        inventoryPage.clickShoppingCart();
        assertEquals("Your Cart",cartPage.getCartTitle());
        cartPage.clickCheckoutBtn();
        assertEquals("Checkout: Your Information", checkoutInfoPage.getCheckoutInfoPageTitle());
        checkoutInfoPage.checkoutSuccessfully("Standard", "User", "1234");
        assertEquals("Checkout: Overview", checkoutOverviewPage.getOverviewPageTitle());
        assertEquals(List.of("Sauce Labs Backpack"),checkoutOverviewPage.getInventoryItemNameList()); //bork
        checkoutOverviewPage.clickFinishBtn();
        assertEquals("Checkout: Complete!", checkoutCompletePage.getCheckoutCompletePageTitle());
        assertEquals("Thank you for your order!",checkoutCompletePage.getCompleteHeaderText());
        assertEquals("Your order has been dispatched, and will arrive just as fast as the pony can get there!",checkoutCompletePage.getCompleteText());
        checkoutCompletePage.clickBackHomeBtn();
        inventoryPage.clickHamburgerMenu();
        inventoryPage.clickLogoutButton();
        assertTrue(mainPage.doesLoginButtonExist());
    }

}
