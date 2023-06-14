package com.codecool.swaglabstestautomationprojectbrreka;

import com.codecool.swaglabstestautomationprojectbrreka.pages.*;
import com.codecool.swaglabstestautomationprojectbrreka.util.InitPropertiesClass;
import com.codecool.swaglabstestautomationprojectbrreka.util.WebdriverClass;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.*;


public class LoginTest {
    static LoginPage mainPage;
    static InventoryPage inventoryPage;
    static Properties properties;

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

    @BeforeAll
    public static void setUpAll() {
        mainPage = new LoginPage();
        inventoryPage = new InventoryPage();
        properties = InitPropertiesClass.getInstance();
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
        WebdriverClass.quit();
    }
}
