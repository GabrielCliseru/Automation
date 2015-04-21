Feature: The homepage of the website

  @homepage
  Scenario: The user reaches the website for the first time
    Given I am on the "http://www.deindeal.ch/de" page for the first time
    When I enter a new email in the newsletter
    And I push on register
    Then the newsletter disappear
    And I save the city
    And I have the right city ticked in "myAccount/Newsletter"
    Then I should see new newsletter popup