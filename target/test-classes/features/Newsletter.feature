Feature: Deindeal Smoketest

  @newsletter
  Scenario: Sign in to the newsletter with a new email address from the new user popup
    Given I am on the "http://www.deindeal.ch/de" page for the first time
    When I enter a new email in the newsletter
    And I save the selected city
    And I push on register
    Then the newsletter disappear
    And I have the right city ticked in myAccount/Newsletter
