Feature: View Cart Contents

  Background: Logged in as standard user
    Given I am on the login page
    And I have entered the correct username and password.
    And I click on Login

  Scenario: Navigate to cart
    Given I am taken to the product listings page.
    When I click on the cart icon
    Then I am taken to the cart page
    And I see an empty cart

  Scenario: Navigate back to products page
    Given I am taken to the product listings page.
    When I click on the cart icon
    And I am taken to the cart page
    And I click on Continue Shopping
    Then I am taken to the product listings page.

  Scenario: Add 1 product to cart and navigate to cart
    Given I am taken to the product listings page.
    When I add 1 items to the cart
    And I click on the cart icon
    And I am taken to the cart page
    Then I see the same products in my cart

  Scenario: Add 6 products to cart and navigate to cart
    Given I am taken to the product listings page.
    When I add 6 items to the cart
    And I click on the cart icon
    And I am taken to the cart page
    Then I see the same products in my cart