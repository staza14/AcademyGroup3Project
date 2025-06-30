@T3_8
Feature: Inventory page displays product information and footer correctly


  Background:
    Given I am on the login page
    And I have entered the correct username and password.
    And I click on Login

  Scenario: Inventory page displays products in grid layout with all required details
    Given User should be see the all product display grid layout
    When all products should be displayed with images, names, and prices
    Then the footer should be see contain links to social media
    And User should see the text "2025 Sauce Labs All Rights of Service Privacy Policy in the footer
