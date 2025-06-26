Feature: Unsuccessful Swag Login

  Background:
    Given I am on the login page

  Scenario Outline: Unsuccessful Login
    Given I have entered an incorrect "<username>" and correct password
    When  I click on Login
    Then  An error message is displayed
    And I remain on the login page
    Examples:
      | username                |
      | problem_user            |
      | performance_glitch_user |
      | error_user|