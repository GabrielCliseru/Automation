Feature: Deindeal login

  @login
  Scenario Outline: Deindeal login
    Given I am on the homepage
    When I click the Sign In button
    And I enter the <username> and <password>
    Then I should receive the following <message>

  Examples:
    | username          | password        | message  |                                                                                |
    | gabriel.cliseru@deindeal.ch | password     | qweqwe|                                                                       |
