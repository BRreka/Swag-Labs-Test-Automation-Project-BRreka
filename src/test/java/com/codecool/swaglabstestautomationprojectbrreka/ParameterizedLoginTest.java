package com.codecool.swaglabstestautomationprojectbrreka;

import com.codecool.swaglabstestautomationprojectbrreka.pages.*;
import com.codecool.swaglabstestautomationprojectbrreka.util.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.*;


public class ParameterizedLoginTest {

    /*
    login with 3 different kind of data should pass for first parameters, and fail for the rest
    login with 3 kind of users should pass for the first two parameters, and only fail for locked out user
     */

    static LoginPage mainPage;
    static InventoryPage inventoryPage;
    static Properties properties;

    @BeforeAll
    public static void setUpAll() {
        properties = InitProperties.getInstance();
    }
    @BeforeEach
    public void setUp() {
        mainPage = new LoginPage();
        inventoryPage = new InventoryPage();
    }

    public static Stream<Arguments> provideStringsForLoginWith3DifferentKindOfData() {
        return Stream.of(
                Arguments.of(properties.getProperty("standardUserName"), properties.getProperty("password")),
                Arguments.of(properties.getProperty("standardUserName"), properties.getProperty("wrongPassword")),
                Arguments.of(properties.getProperty("standardUserName"), "")
        );
    }

    public static Stream<Arguments> provideStringsForLoginWith3DifferentUsers() {
        return Stream.of(
                Arguments.of(properties.getProperty("standardUserName"), properties.getProperty("password")),
                Arguments.of(properties.getProperty("problemUserName"), properties.getProperty("password")),
                Arguments.of(properties.getProperty("lockedOutUserName"), properties.getProperty("password"))
        );
    }

    @ParameterizedTest
    @MethodSource("provideStringsForLoginWith3DifferentKindOfData")
    public void testLoginWith3DifferentKindOfData(String userName, String password) {
        mainPage.login(userName, password);
        assertEquals("Swag Labs", inventoryPage.getPageTitleText());
        inventoryPage.clickHamburgerMenu();
        assertTrue(inventoryPage.doesLogoutButtonExist());
        inventoryPage.clickLogoutButton();
    }

    @ParameterizedTest
    @MethodSource("provideStringsForLoginWith3DifferentUsers")
    public void testLoginWith3DifferentUsers(String userName, String password) {
        mainPage.login(userName, password);
        assertEquals("Swag Labs", inventoryPage.getPageTitleText());
        inventoryPage.clickHamburgerMenu();
        assertTrue(inventoryPage.doesLogoutButtonExist());
        inventoryPage.clickLogoutButton();
    }

    @AfterEach
    public void tearDown() {
        WebdriverUtil.quit();
    }
}
