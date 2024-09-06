# File: src/test/resources/features/login.feature
@All
Feature: Login

  @Test1
  Scenario: Successful login
    Given I am on the login page
    When I enter username and password
    Then I should see the dashboard page
  @Test2
  Scenario: Failed login
    Given I am on the login page
    When I enter invalid username and password
    Then I should see message Invalid username or password
  @Test3
  Scenario: Failed login
    Given I am on the login page
    When I click Login Button
    Then I should see message "Username is required"

