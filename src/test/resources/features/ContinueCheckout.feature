Feature: Continue Checkout

  Background:
    Given I am on the login page
    And I have entered the correct username and password.
    And I click on Login
    And I add 2 products to the cart
    And I navigate to the cart page
    And I click the "Checkout" button

  Scenario: User can proceed through checkout when all fields are filled
    When I fill in the First Name field
    And I fill in the Last Name field
    And I fill in the Postal Code field
    And I click the ‘Continue’ button
    Then I should be navigated to the Checkout Overview page

  Scenario Outline: User cannot proceed through checkout without completing all checkout fields
    When I incorrectly fill in the "<First Name>", "<Last Name>" and "<Postal Code>"
    And I click the ‘Continue’ button
    Then I should remain on the Checkout Information page
    And I should see a checkout error message

    Examples:
      | First Name | Last Name | Postal Code |
      |            | Doe       | 12345       |
      | Jane       |           | 12345       |
      | Jane       | Doe       |             |
      |            |           |             |