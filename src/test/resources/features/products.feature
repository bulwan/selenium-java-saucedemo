Feature: Checkout
  As a logged user I should be able to add products to a cart and open checkout section so I can complete an order
  successfully.

  Background:
    Given I log in as "standard_user"

  Scenario: Number of products in cart
    Then I shouldn't see cart indicator
    When I add "Sauce Labs Bike Light" to the cart
    Then I should see "1" indicator
    When I add "Sauce Labs Fleece Jacket" to the cart
    When I add "Sauce Labs Onesie" to the cart
    Then I should see "3" indicator
    When I remove "Sauce Labs Bike Light" from the cart
    Then I should see "2" indicator


  Scenario: Purchase single product
    When I add "Sauce Labs Bike Light" to the cart
    And I go to the cart
    Then Product "Sauce Labs Bike Light" is in cart
    When I click "Checkout" button
    And I enter form with
      | First Name      | Joe   |
      | Last Name       | Smith |
      | Zip/Postal Code | 00000 |
    And I click "Continue" button
    And I click "Finish" button
    Then I see Thank you page