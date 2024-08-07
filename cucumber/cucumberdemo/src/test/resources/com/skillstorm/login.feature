@login
Feature: User Login

  Scenario Outline: Successful login with valid credentials
    Given I am on the login page
    When I enter valid "<username>" and "<password>"
    And I click the login button
    Then I should be redirected to the main page
    Then I should see a sign off link

  Examples:
    |username | password|
    |admin    | admin   |
    |jsmith   | Demo1234|

  Scenario: Unsuccessful login with invalid credentials
    Given I am on the login page
    When I enter invalid "username" and "password"
    And I click the login button
    Then I should see an error message "Login Failed"

