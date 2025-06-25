Feature: Swag Login

  Background:
    Given I am on the login page

  Scenario: Successful Login
    Given I have entered the correct username and password.
    When  I click on Login
    Then  I am taken to the product listings page.