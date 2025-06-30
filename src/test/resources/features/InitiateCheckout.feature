Feature: Initiate Checkout

  Background:
    Given I am on the login page
    And I have entered the correct username and password.
    And I click on Login
    Then I am taken to the product listings page.


  Scenario: Initiate checkout with 2 items in cart
    When I add 2 products to the cart
    And I navigate to the cart page
    And I click the "Checkout" button
    Then I should be taken to the checkout information page
    And I should be prompted to enter my personal information

  @known_defect
  Scenario: Initiate checkout with 0 items in cart
    When I navigate to the cart page
    And I click the "Checkout" button
    Then I should not navigate to the checkout information page
