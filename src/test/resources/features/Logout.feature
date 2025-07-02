Feature: Logout Functionality

  Background:
    Given I am on the login page
    And I have entered the correct username and password.
    And I click on Login


  Scenario: Successful logout
    When user clicks on the menu button
    And  user selects Logout
    And I try to access the product listings page
    Then I should be redirected to the login page


