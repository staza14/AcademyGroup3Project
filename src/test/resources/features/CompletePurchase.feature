Feature: Complete Purchase

  Background: Logged in as standard user, added items to cart and navigated to checkout
    Given I am on the login page
    And I have entered the correct username and password.
    And I click on Login
    And I add 6 items to the cart
    And I click on the cart icon
    And I click the "Checkout" button
    And I fill in the First Name field
    And I fill in the Last Name field
    And I fill in the Postal Code field
    And I click the ‘Continue’ button

  Scenario: Checkout and see Checkout Overview
    Given I should be navigated to the Checkout Overview page
    Then I see the item details
    And I see the total cost

  Scenario: Complete checkout and see 'Back Home' button
    Given I should be navigated to the Checkout Overview page
    When I click the 'Finish' button
    Then I see the order confirmation message
    And I see the 'Back Home' button



