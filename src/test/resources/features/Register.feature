Feature: Register

  @register
  Scenario: Register user with a new email address
    Given I am on the homepage
    When I click on the "Login/Register" button
    And I click on the "Register"
    And I fill in the email
    And I fill in the password
    And I check the "#checkAcceptTerms" checkbox
    And I press on the "Register" button
    Then I should not see the "Register" popup
    And I should be logged in wrapper