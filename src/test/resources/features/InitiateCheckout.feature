Feature: Initiate Checkout

  Background:
    Given I am on the login page
    And I have entered the correct username and password.
    And I click on Login
    And I am taken to the product listings page.
    And I add 2 products to the cart
    And I navigate to the cart page

  Scenario: Removing 1 item from the cart via product inventory page
    When I click the "Checkout" button
    Then I should be taken to the checkout information page
    And I should be prompted to enter my personal information