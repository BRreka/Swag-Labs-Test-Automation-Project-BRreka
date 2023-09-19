Feature: Login Action
  As a user of the Swag Labs website
  I want to be able to log in to my account
  So I can access my account-related features and manage my orders

  Background:
    Given I am on the Swag Labs login page

  Scenario: Successful Login with Valid Credentials
    Given I have entered a valid username and password
    When I click on the login button
    Then I should be logged in successfully

  Scenario: Unsuccessful Login with invalid password
    Given I have entered valid username but invalid password
    When I click on the login button
    Then I should see an error message indicating wrong credentials

  Scenario: Unsuccessful Login with empty password
    Given I have entered valid username but no password
    When I click on the login button
    Then I should see an error message requiring password

  Scenario: Unsuccessful Login when Locked Out
    Given I have entered a valid username and password with a locked out account
    When I click on the login button
    Then I should see an error message about locked out from account