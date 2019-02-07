Feature: Automate Form Authentication

  @login
  Scenario: Login with valid username and invalid password and assert login validation
    Given I am on the login page
    When I enter valid username
    And I enter invalid password
    And Click on Login
    Then validate Login Assertion "Your password is invalid!"

  @login
  Scenario: Login with invalid username and valid password and assert login validation
    Given I am on the login page
    When I enter invalid username
    And I enter valid password
    And Click on Login
    Then validate Login Assertion "Your username is invalid!"

  @login
  Scenario: Login with valid username and valid password and then logout
    Given I am on the login page
    When I enter valid username
    And I enter valid password
    And Click on Login
    Then Click on Logout Button

    
    
    