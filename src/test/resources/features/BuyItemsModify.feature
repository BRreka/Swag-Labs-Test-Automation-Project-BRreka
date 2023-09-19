Feature: Buy and modify items action
  As a user of the Swag Labs website
  I want to be able to modify my order and buy items

  Background:
    Given I am on the Swag Labs login page

  Scenario: Successfully Buying one of two Items After Deleting the Other
    Given I have logged in successfully
    When I add fleece jacket and onesie item to cart and click on cart button
    And click on remove button for onesie
    And click on checkout
    And enter my first name, last name and postal code
    And reviewed my item (fleece jacket) showing up correctly
    And click on finish button
    Then the checkout complete page appears

  Scenario: Successfully Buying Two Items After Adding one plus one
    Given I have logged in successfully
    When I add backpack item to cart and click on cart button
    And click on continue shopping button
    And click on All the things T-shirt to add to my order and click on cart button again
    And click on checkout
    And enter my first name, last name and postal code
    And reviewed my items (backpack, T-shirt) showing up correctly
    And click on finish button
    Then the checkout complete page appears