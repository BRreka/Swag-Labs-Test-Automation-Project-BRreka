package com.codecool.swaglabstestautomationprojectbrreka;

import com.codecool.swaglabstestautomationprojectbrreka.pages.*;
import com.codecool.swaglabstestautomationprojectbrreka.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class BuyItemsTest {

    /*
    tests present in this class should pass
    except for the last one with problem user
     */

    static LoginPage mainPage;
    static InventoryPage inventoryPage;
    static CartPage cartPage;
    static CheckoutInfoPage checkoutInfoPage;
    static CheckoutCompletePage checkoutCompletePage;
    static CheckoutOverviewPage checkoutOverviewPage;
    static Properties properties;

    //variables for the names of products
    private String backpack = "Sauce Labs Backpack";
    private String bikeLight = "Sauce Labs Bike Light";
    private String boltTShirt = "Sauce Labs Bolt T-Shirt";
    private String fleeceJacket = "Sauce Labs Fleece Jacket";
    private String onesie = "Sauce Labs Onesie";
    private String allTheThings = "Test.allTheThings() T-Shirt (Red)";

    @BeforeAll
    public static void setUpAll() {
        properties = InitProperties.getInstance();
    }

    @BeforeEach
    public void setUp() {
        mainPage = new LoginPage();
        inventoryPage = new InventoryPage();
        cartPage = new CartPage();
        checkoutInfoPage = new CheckoutInfoPage();
        checkoutCompletePage = new CheckoutCompletePage();
        checkoutOverviewPage = new CheckoutOverviewPage();
    }

    @Test
    public void testBuyingSauceLabsBackpackAndLogout() {
        //thorough test checking titles
        mainPage.login(properties.getProperty("standardUserName"), properties.getProperty("password"));
        assertEquals("Swag Labs", inventoryPage.getPageTitleText());
        inventoryPage.addBackpackToCartAndClickCart();
        assertEquals("Your Cart",cartPage.getCartTitle());
        cartPage.clickCheckoutBtn();
        assertEquals("Checkout: Your Information", checkoutInfoPage.getCheckoutInfoPageTitle());
        checkoutInfoPage.checkoutSuccessfully("Standard", "User", "1234");
        assertEquals("Checkout: Overview", checkoutOverviewPage.getOverviewPageTitle());
        assertEquals(List.of(backpack),checkoutOverviewPage.getInventoryItemNameList());
        checkoutOverviewPage.clickFinishBtn();
        assertEquals("Checkout: Complete!", checkoutCompletePage.getCheckoutCompletePageTitle());
        assertEquals("Thank you for your order!",checkoutCompletePage.getCompleteHeaderText());
        assertEquals("Your order has been dispatched, and will arrive just as fast as the pony can get there!",checkoutCompletePage.getCompleteText());
        checkoutCompletePage.clickBackHomeBtn();
        inventoryPage.clickOnMenuAndLogout();
        assertTrue(mainPage.doesLoginButtonExist());
    }

    @Test
    public void testBuyingMultipleItemsAndLogout() {
        mainPage.login(properties.getProperty("standardUserName"), properties.getProperty("password"));
        inventoryPage.addAllItemsAndClickCart();
        cartPage.clickCheckoutBtn();
        checkoutInfoPage.checkoutSuccessfully("Standard", "User", "1234");
        assertEquals(List.of(backpack, bikeLight, boltTShirt, fleeceJacket, onesie, allTheThings),checkoutOverviewPage.getInventoryItemNameList());
        checkoutOverviewPage.clickFinishBtn();
        checkoutCompletePage.clickBackHomeBtn();
        inventoryPage.clickOnMenuAndLogout();
        assertTrue(mainPage.doesLoginButtonExist());
    }

    @Test
    public void testBuyingTwoItemsButDeletingOne() {
        mainPage.login(properties.getProperty("standardUserName"), properties.getProperty("password"));
        inventoryPage.addFleeceJacketAndOnesieAndClickCart();
        cartPage.clickRemoveBtn(onesie);
        cartPage.clickCheckoutBtn();
        checkoutInfoPage.checkoutSuccessfully("Standard", "User", "1234");
        assertEquals(List.of(fleeceJacket),checkoutOverviewPage.getInventoryItemNameList());
        checkoutOverviewPage.clickFinishBtn();
        checkoutCompletePage.clickBackHomeBtn();
        inventoryPage.clickOnMenuAndLogout();
        assertTrue(mainPage.doesLoginButtonExist());
    }

    @Test
    public void testBuyingOneItemThenAddingOneMore() {
        mainPage.login(properties.getProperty("standardUserName"), properties.getProperty("password"));
        inventoryPage.addBackpackToCartAndClickCart();
        cartPage.clickContinueShopping();
        inventoryPage.addAllTheThingsTShirtAndClickCart();
        cartPage.clickCheckoutBtn();
        checkoutInfoPage.checkoutSuccessfully("Standard", "User", "1234");
        assertEquals(List.of(backpack, allTheThings),checkoutOverviewPage.getInventoryItemNameList());
        checkoutOverviewPage.clickFinishBtn();
        checkoutCompletePage.clickBackHomeBtn();
        inventoryPage.clickOnMenuAndLogout();
        assertTrue(mainPage.doesLoginButtonExist());
    }

    /*
    this test is
    set up to fail :(
     */
    @Test
    public void buyItemsWithProblemUser() {
        mainPage.login(properties.getProperty("problemUserName"), properties.getProperty("password"));
        inventoryPage.addAllItemsAndClickCart();
        cartPage.clickCheckoutBtn();
        checkoutInfoPage.checkoutSuccessfully("Problem", "User", "1234");
        assertEquals(List.of(backpack, bikeLight, boltTShirt, fleeceJacket, onesie, allTheThings),checkoutOverviewPage.getInventoryItemNameList());
        checkoutOverviewPage.clickFinishBtn();
        checkoutCompletePage.clickBackHomeBtn();
        inventoryPage.clickOnMenuAndLogout();
        assertTrue(mainPage.doesLoginButtonExist());
    }

    @AfterEach
    public void tearDown() {
        WebdriverUtil.quit();
    }

}
