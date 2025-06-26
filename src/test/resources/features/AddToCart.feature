Feature: Add to Cart

  Background:
    Given I am on the login page
    And I have entered the correct username and password.
    And I click on Login
    And I am taken to the product listings page.

  Scenario: Adding a single item to the cart
    When I add 1 products to the cart
    Then the cart icon displays "1"

  Scenario: Adding the maximum number of items
    When I add 6 products to the cart
    Then the cart icon displays "6"