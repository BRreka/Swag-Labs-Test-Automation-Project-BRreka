package com.codecool.swaglabstestautomationprojectbrreka;

import com.codecool.swaglabstestautomationprojectbrreka.pages.*;
import com.codecool.swaglabstestautomationprojectbrreka.util.*;
import cucumber.api.java.en.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class CucumberTestSteps {
    LoginPage mainPage;
    InventoryPage inventoryPage;
    Properties properties = InitProperties.getInstance();
    @Given("I am on the Swag Labs login page")
    public void iAmOnTheSwagLabsLoginPage() {
        mainPage = new LoginPage();
        inventoryPage = new InventoryPage();
        mainPage.manageDriverInit();
    }

    @Given("I have entered a valid username and password")
    public void iHaveEnteredAValidUsernameAndPassword() {
        String username = properties.getProperty("standardUserName");
        String password = properties.getProperty("password");
        mainPage.enterUserNameAndPassword(username, password);
    }

    @When("I click on the login button")
    public void iClickOnTheLoginButton() {
        mainPage.clickLoginButton();
    }

    @Then("I should be logged in successfully")
    public void iShouldBeLoggedInSuccessfully() {
        //to know I have logged in successfully, both I have to check I'm on the right page, and if logout button exists
        assertEquals("Swag Labs", inventoryPage.getPageTitleText());
        inventoryPage.clickHamburgerMenu();
        assertTrue(inventoryPage.doesLogoutButtonExist());
        inventoryPage.clickLogoutButton();
    }

    @Given("I have entered valid username but invalid password")
    public void iHaveEnteredValidUsernameButInvalidPassword() {
        String username = properties.getProperty("standardUserName");
        String wrongPassword = properties.getProperty("wrongPassword");
        mainPage.enterUserNameAndPassword(username, wrongPassword);
    }

    @Then("I should see an error message indicating wrong credentials")
    public void iShouldSeeAnErrorMessageIndicatingWrongCredentials() {
        assertEquals("Epic sadface: Username and password do not match any user in this service", mainPage.getErrorMessage());
    }


    @Given("I have entered valid username but no password")
    public void iHaveEnteredValidUsernameButNoPassword() {
        String username = properties.getProperty("standardUserName");
        mainPage.enterUserNameAndPassword(username, "");
    }

    @Then("I should see an error message requiring password")
    public void iShouldSeeAnErrorMessageRequiringPassword() {
        assertEquals("Epic sadface: Password is required", mainPage.getErrorMessage());assertEquals("Epic sadface: Password is required", mainPage.getErrorMessage());
    }

    @Given("I have entered a valid username and password with a locked out account")
    public void iHaveEnteredAValidUsernameAndPasswordWithALockedOutAccount() {
        String username = properties.getProperty("lockedOutUserName");
        String password = properties.getProperty("password");
        mainPage.enterUserNameAndPassword(username, password);
    }

    @Then("I should see an error message about locked out from account")
    public void iShouldSeeAnErrorMessageAboutLockedOutFromAccount() {
        assertEquals("Epic sadface: Sorry, this user has been locked out.", mainPage.getErrorMessage());
    }
}
