package com.codecool.swaglabstestautomationprojectbrreka;

import com.codecool.swaglabstestautomationprojectbrreka.pages.*;
import com.codecool.swaglabstestautomationprojectbrreka.util.InitPropertiesClass;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.*;


public class LoginTest {
    static LoginPage mainPage;
    static InventoryPage inventoryPage;
    static CartPage cartPage;
    static CheckoutInfoPage checkoutInfoPage;
    static CheckoutCompletePage checkoutCompletePage;
    static CheckoutOverviewPage checkoutOverviewPage;
    static Properties properties;

    public static Stream<Arguments> provideStringsForLoginWith3DifferentUsers() {
        return Stream.of(
                Arguments.of(properties.getProperty("standardUserName")),
                Arguments.of(properties.getProperty("problemUserName")),
                Arguments.of(properties.getProperty("lockedOutUserName"))
        );
    }

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

    @ParameterizedTest
    @MethodSource("provideStringsForLoginWith3DifferentUsers")
    public void testLoginWith3DifferentUsers(String userName) {
        mainPage.login(userName, properties.getProperty("password"));
        assertEquals("Swag Labs", inventoryPage.getPageTitleText());
        inventoryPage.clickHamburgerMenu();
        assertTrue(inventoryPage.doesLogoutButtonExist());
        inventoryPage.clickLogoutButton();
    }

    @AfterEach
    public void tearDown() {
    }
}
