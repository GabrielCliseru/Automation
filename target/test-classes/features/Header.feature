Feature: Header

  @readyToRun
  Scenario Outline: Header discount information link validation
    Given I am on the homepage as an existing visitor on "<language>"
    And language is set to "<language>"
    When I click the header "<discount>" link
    Then I should land on "<discountlink>"
    Examples:
      | language | discount             | discountlink                                 |
      | DE       | BIS ZU 70% RABATT *  | /de/wie-funktioniert-deindeal#anchor-lower   |
      | FR       | DE REMISE MAXIMALE * | /fr/comment-fonctionne-deindeal#anchor-lower |

  @readyToRun
  Scenario Outline: Header refund information link validation
    Given I am on the homepage as an existing visitor on "<language>"
    And language is set to "<language>"
    When I click the header "<refund>" link
    Then I should land on "<refundlink>"
    Examples:
      | language | refund                     | refundlink                                   |
      | DE       | 14 TAGE Rückgaberecht      | /de/wie-funktioniert-deindeal#anchor-lower   |
      | FR       | DROIT DE RETOUR : 14 JOURS | /fr/comment-fonctionne-deindeal#anchor-lower |

  @readyToRun
  Scenario Outline: Header customer care phone number link validation
    Given I am on the homepage as an existing visitor on "<language>"
    And language is set to "<language>"
    Then I should see "<customer_care_number>"
    And "<customer_care_number>" should not be a link
    Examples:
      | language | customer_care_number      |
      | DE       | LOKALTARIF 0848 500 501   |
      | FR       | TARIF LOCALE 0848 500 501 |

  @readyToRun
  Scenario Outline: Header Kontakt form link validation
    Given I am on the homepage as an existing visitor on "<language>"
    And language is set to "<language>"
    When I click the header "<Kontakt>" link
    Then I should land on "<Kontakt_form>"
    Examples:
      | language | Kontakt     | Kontakt_form  |
      | DE       | SCHREIB UNS | /de/kontakt   |
      | FR       | ECRIS-NOUS  | /fr/contacter |


  @readyToRun
  Scenario Outline: Header language select validation
    # Selecting the channel page is done from the header
    Given I am on "any" channel as an existing visitor
    When I select the "<language>" language
    Then I should see "<language>" selected
    # The URL in the browser should be the corresponding one for each language
    And channel url is set to "<language>"
    Examples:
      | language |
      | DE       |
      | FR       |

  @readyToRun
  Scenario Outline: Header DeinDeal logo redirect validation
    Given I am on "any" channel as an existing visitor on "<language>"
    And language is set to "<language>"
    When I click the DeinDeal logo
    Then I should land on homepage
    And language is set to "<language>"
    Examples:
      | language |
      | de       |
      | fr       |

    @gabi
  Scenario Outline: Header DeinDeal logo redirect from checkout validation
      Given I am on "any" channel as an existing visitor
      Given I enter a random collection
#    Given I am on the checkout page
#    And language is set to "<language>"
#    When I click the DeinDeal logo
#    Then I should land on homepage
    Examples:
      | language |
      | DE       |
      | FR       |

  @readyToRun
  Scenario Outline: Basic search bar verification
    Given I am on "any" channel as an existing visitor on "<language>"
    And language is set to "<language>"
    Then the search section should contain "<search_hint_text>" and "<search_button>"

    Examples:
      | language | search_hint_text            | search_button |
      | de       | Was suchst du?              | JETZT SUCHEN  |
      | fr       | Que cherches-tu ?           | RECHERCHE     |

  @readyToRun
  Scenario Outline: Empty search results
    Given I am on "any" channel as an existing visitor on "<language>"
    And language is set to "<language>"
    And I see "<search_hint_text>" on the search input
    When I click the search button
    Then I should land on "<empty_search_page>"
  Examples:
      | language | search_hint_text            | empty_search_page  |
      | DE       | Was suchst du?              | /de/search?q=&l=60 |
      | FR       | Que cherches-tu ?           | /fr/search?q=&l=60 |

  @readyToRun
  Scenario Outline: Login/Register button
    Given I am on "any" channel as an existing visitor on "<language>"
    And language is set to "<language>"
    And the login/register button is named "<login_button>"
    When I click on the login/register button
    Then I should see the login pop up

    Examples:
      | language | login_button                 |
      | DE       | Login / Registrieren         |
      | FR       | Se connecter / s'enregistrer |

  @readyToRun
  Scenario Outline: Cart Pop Up Button
    Given I am on "any" channel as an existing visitor on "<language>"
    And language is set to "<language>"
    And the cart button is named "<cart_button>"
    When I click  the cart button
    Then I should see the cart pop up

  Examples:
    | language | cart_button    |
    | DE       | Dein Warenkorb |
    | FR       | Ton panier     |
