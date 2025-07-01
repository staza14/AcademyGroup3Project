Feature: Swag Login

  Background:
    Given I am on the login page

  Scenario: Successful Login
    Given I have entered the correct username and password.
    When  I click on Login
    Then  I am taken to the product listings page.

  Scenario: Login fails with empty username and password
    When I click on Login
    Then I should see a "x" icon next to the username field
    And I should see a "x" icon next to the password field
    And I should see an error message "Username is required"

  Scenario: Login fails with username only
    When I enter a username but leave the password blank
    And I click on Login
    Then I should see a "x" icon next to the password field
    And I should see an error message "Password is required"

  Scenario: Login fails with password only
    When I enter a password but leave the username blank
    And I click on Login
    Then I should see a "x" icon next to the username field
    And I should see an error message "Username is required"

  Scenario: Session is maintained after login
    Given I have entered the correct username and password.
    And I click on Login
    When I refresh the page
    Then I am taken to the product listings page.

  Scenario: Session ends after browser is closed
    Given I have entered the correct username and password.
    And I click on Login
    When I close the browser completely
    And I reopen the browser
    And I try to access the product listings page
    Then I should be redirected to the login page
