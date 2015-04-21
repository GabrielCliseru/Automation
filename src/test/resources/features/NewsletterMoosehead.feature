Feature: The newsletter section in moosehead

  @newsletterMoosehead
  Scenario: Search for which cities a user is subscribed to
    Given I login into Moosehead
    When I navigate to the "Newsletter" section
    And I look for "cosmin.uta@deindeal.ch"
    And I edit the user's "newsletters" details
    Then I should see the cities in which the user is subscribed