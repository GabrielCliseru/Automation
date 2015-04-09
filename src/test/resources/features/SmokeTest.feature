Feature: Deindeal login Demo

  @bleablea
  Scenario: Deindeal login
    Given I am on the homepage
    When I click the Sign In button
    And I enter the <username> and <password>
    Then I should receive the following <message>