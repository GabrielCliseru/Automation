Feature: Deindeal login

  @login
  Scenario: Deindeal login
    Given I am on the homepage
    When I click the Sign In button
    And I enter the "random" and "password"
    Then I should not see the "login" popup