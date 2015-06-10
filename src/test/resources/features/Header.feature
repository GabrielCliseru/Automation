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


  @NavigateToAllChannels
    #TODO: Must find a solution to pass variables between test classes and test runs
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

  @NavigateToAllChannels
  Scenario Outline: Header DeinDeal logo redirect validation
    Given I am on the "<channel_page>"
    And language is set to "<language>"
    When I click the DeinDeal logo
    Then I should land on homepage
    Examples:
      | language |
      | DE       |
      | FR       |

  Scenario Outline: Header DeinDeal logo redirect from checkout validation
    Given I am on the checkout page
    And language is set to "<language>"
    When I click the DeinDeal logo
    Then I should land on homepage
    Examples:
      | language |
      | DE       |
      | FR       |