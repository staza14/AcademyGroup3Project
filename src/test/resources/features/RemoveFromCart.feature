Feature: Remove From Cart

  Background:
    Given I am on the login page
    And I have entered the correct username and password.
    And I click on Login
    And I am taken to the product listings page.
    And I add 6 products to the cart

  Scenario: Removing 1 item from the cart via product inventory page
    When I remove 1 products from the cart
    Then on the product inventory page the button now says 'add to cart'
    And the cart icon displays "5"
    And on the cart page the product should be removed

  Scenario: Removing 1 item from the cart page via the cart page
    Given I navigate to the cart page
    When I remove 1 products from the cart
    Then on the cart page the product should be removed
    And the cart icon displays "5"
    And on the product inventory page the button now says 'add to cart'

  Scenario: Removing all items from the cart via the cart page
    Given I navigate to the cart page
    When I remove 6 products from the cart
    Then the cart should be empty
    And the cart icon should not display a number
    And on the product inventory page the button now says 'add to cart'
