Feature: Swag Login

  Background:
    Given I am on the login page

  Scenario: Locked Out User Login
    Given I have entered locked out username and locked out password
    When  I click on Login
    Then  I should see an error message
    And   I should not navigate to the products page