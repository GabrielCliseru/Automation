Feature: The homepage of the website

  @homepage
  Scenario: The user reaches the website for the first time
    Given I am on the "http://www.deindeal.ch/de" page for the first time
    Then I should see new newsletter popup