Feature: Deindeal login

  @login
  Scenario: Deindeal login fail
    Given I am on the homepage as an existing visitor
    When I click the Sign In button
    And I enter the "random" and "password"
    Then I should see the "errorMessages_unregistered_email" alert