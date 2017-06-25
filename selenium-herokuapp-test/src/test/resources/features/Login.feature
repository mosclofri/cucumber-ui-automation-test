Feature: Login
  As a user
  I want to login
  So that i can see 'Home Page'

  Scenario: I login with valid credential
    Given I am on 'Login Page' screen
    When I enter 'tomsmith' as username and 'SuperSecretPassword!' as password
    Then I 'Home Page' should be displayed