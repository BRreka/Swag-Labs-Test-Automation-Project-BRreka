package com.codecool.swaglabstestautomationprojectbrreka;

import com.codecool.swaglabstestautomationprojectbrreka.pages.*;
import com.codecool.swaglabstestautomationprojectbrreka.util.InitPropertiesClass;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class SeparateLoginTest {

    static LoginPage mainPage;
    static InventoryPage inventoryPage;
    static Properties properties;

    @BeforeAll
    public static void setUpAll() {
        mainPage = new LoginPage();
        inventoryPage = new InventoryPage();
        properties = InitPropertiesClass.getInstance();
    }

    @Test
    public void testStandardUserLogin() {
        mainPage.login(properties.getProperty("standardUserName"), properties.getProperty("password"));
        assertEquals("Swag Labs", inventoryPage.getPageTitleText());
        inventoryPage.clickHamburgerMenu();
        assertTrue(inventoryPage.doesLogoutButtonExist());
        inventoryPage.clickLogoutButton();
    }

    @Test
    public void testStandardUserLoginWithWrongPassword() {
        mainPage.login(properties.getProperty("standardUserName"), properties.getProperty("wrongPassword"));
        assertEquals("Epic sadface: Username and password do not match any user in this service", mainPage.getErrorMessage());
    }

    @Test
    public void testStandardUserLoginWithNoPassword() {
        mainPage.login(properties.getProperty("standardUserName"), "");
        assertEquals("Epic sadface: Password is required", mainPage.getErrorMessage());
    }

    @Test
    public void testLockedOutUserLogin() {
        mainPage.login(properties.getProperty("lockedOutUserName"), properties.getProperty("password"));
        assertEquals("Epic sadface: Sorry, this user has been locked out.", mainPage.getErrorMessage());
    }

}
