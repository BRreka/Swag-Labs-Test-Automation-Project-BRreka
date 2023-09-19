Feature: Buy items action
  As a user of the Swag Labs website
  I want to be able to buy items

  Background:
    Given I am on the Swag Labs login page

  Scenario: Successfully Buying one Item and Logout
    Given I have logged in successfully
    When I add backpack item to cart and click on cart button
    And click on checkout
    And enter my first name, last name and postal code
    And reviewed my order item (backpack) showing up correctly
    And click on finish button
    Then the checkout complete page appears

    Scenario: Successfully Buying Multiple Items and Logout
      Given I have logged in successfully
      When I add multiple items to cart and click on cart button
      And click on checkout
      And enter my first name, last name and postal code
      And reviewed my multiple order items showing up correctly
      And click on finish button
      Then the checkout complete page appears