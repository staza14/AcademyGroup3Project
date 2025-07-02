Feature: Inventory page displays product information and footer correctly


  Background:
    Given I am on the login page
    And I have entered the correct username and password.
    And I click on Login

  Scenario: Inventory page displays product with all required details
    Given user is on inventory page
    Then all products should be displayed with images, names, and prices



  Scenario: User can see footer containing links to social media and text
    Given user is on inventory page
    Then User should see the text 2025 Sauce Labs All Rights of Service Privacy Policy in the footer