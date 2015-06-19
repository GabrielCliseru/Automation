Feature: Deindeal login

  @login @readyToRun
  Scenario: Deindeal login fail with nonregistered account
    Given I am on the homepage as an existing visitor
    When I click the Sign In button
    And I enter the "random" and "password"
    Then I should see the "errorMessages_unregistered_email" alert

  Scenario Outline: Deindeal login fail with empty fields
    Given I am on the homepage as an existing visitor
    And language is set to "<string>"
    When I click the Sign In button
    Then I should see the "<empty_email>" alert
    And I should see the "<empty_password>" alert

    Examples:
      | string | empty_email                                                     | empty_password                      |
      | DE     | Das hat leider nicht geklappt. Bitte versuche es noch einmal... | Bitte gib hier Dein Passwort ein... |
      | FR     | Une erreur est survenue. Veuillez réessayer..                   | Entrez votre mot de passe ici       |

  Scenario Outline: Deindeal login fail with empty password field
    Given I am on the homepage as an existing visitor
    And language is set to "<string>"
    When I enter the "daniel.rotariu@deindeal.ch" in the "email address" text box
    And I click the Sign In button
    Then I should see the "<empty_password>" alert

    Examples:
      | string | empty_password                      |
      | DE     | Bitte gib hier Dein Passwort ein... |
      | FR     | Entrez votre mot de passe ici       |

    Scenario: Dismiss login pop-up using close button
      Given I am on the homepage as an existing visitor
      When I click the Sign In button
      And I click the close button
      Then the Sign in pop-up should close

  Scenario: Dismiss login pop-up clicking outside the pop-up
    Given I am on the homepage as an existing visitor
    When I click the Sign In button
    And I click outside the pop-up
    Then the Sign in pop-up should close