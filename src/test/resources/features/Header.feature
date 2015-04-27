Feature: Header
Background: I should not see the "new page" popup

  #sa ma plimb la toate canalele
  @NavigateToAllChannels
  Scenario Outline: Header discount information link validation
    Given I am on the homepage
    And language is set to "<language>"
    When I click the header "<discount>" link
    Then I should land on "<discountlink>"
  Examples:
    | language | discount             | discountlink                                                       |
    | DE       | BIS ZU 70% RABATT *  | http://www.deindeal.ch/de/wie-funktioniert-deindeal#anchor-lower   |
    | FR       | DE REMISE MAXIMALE * | http://www.deindeal.ch/fr/comment-fonctionne-deindeal#anchor-lower |

#  Scenario: Header validation
#  Given I am on the homepage
#  And language is set to "DE"
#  When I click the "BIS ZU 70% RABATT *" link
#  Then I should land on "http://www.deindeal.ch/de/wie-funktioniert-deindeal#anchor-lower"

  @NavigateToAllChannels
  Scenario Outline: Header refund information link validation
    Given I am on the homepage
    And language is set to "<language>"
    When I click the header "<refund>" link
    Then I should land on "<refundlink>"
  Examples:
    | language | refund                     | refundlink                                                         |
    | DE       | 14 TAGE RÜCKGABERECHT      | http://www.deindeal.ch/de/wie-funktioniert-deindeal#anchor-lower   |
    | FR       | DROIT DE RETOUR : 14 JOURS | http://www.deindeal.ch/fr/comment-fonctionne-deindeal#anchor-lower |