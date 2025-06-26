Feature: Sort Products

  Background: Logged in as standard user
    Given I am on the login page
    And I have entered the correct username and password.
    And I click on Login
    Then I am taken to the product listings page.

  Scenario: Sort by Price (low to high)
    When I click sort by Price low to high
    Then the products are sorted from lowest to highest

  Scenario: Sort by Price (high to low)
    When I click sort by Price high to low
    Then the products are sorted from highest to lowest

  Scenario: Sort by Name (A to Z)
    When I click sort by Name A to Z
    Then the products are sorted alphabetically

  Scenario: Sort by Name (Z to A)
    When I click sort by Name Z to A
    Then the products are sorted in reverse alphabetical order

