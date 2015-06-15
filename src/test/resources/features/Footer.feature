Feature: This is the footer of our website

  Scenario Outline: Footer icons and static link validation
    Given I am on the homepage as an existing visitor on "<language>"
    And language is set to "<language>"
    And I scroll to footer
    When I click on "<page element>"
    Then I should land on "<page link>"
    Examples:
      | language | page element         | page link                                                                                     |
      | DE       | trustedshop          | https://www.trustedshops.de/shop/certificate.php?shop_id=%20X7876D2C94CAF46E8663D48F4331D653A |
      | FR       | trustedshop          | https://www.trustedshops.de/shop/certificate.php?shop_id=%20X7876D2C94CAF46E8663D48F4331D653A |
      | DE       | swissgarantie        | http://www.vsv-versandhandel.ch/                                                              |
      | FR       | swissgarantie        | http://www.vsv-versandhandel.ch/                                                              |
      | DE       | iosdownload          | https://itunes.apple.com/ch/app/deindeal/id465657999?mt=8                                     |
      | FR       | iosdownload          | https://itunes.apple.com/fr/app/deindeal/id465657999?mt=8                                     |
      | DE       | androiddownload      | https://play.google.com/store/apps/details?id=ch.deindeal.android&hl=de                       |
      | FR       | androiddownload      | https://play.google.com/store/apps/details?id=ch.deindeal.android&hl=fr                       |
      | DE       | googleplus           | https://plus.google.com/+DeindealCh1/posts                                                    |
      | FR       | googleplus           | https://plus.google.com/+DeindealCh1/posts                                                    |
      | DE       | facebook             | https://www.facebook.com/DeinDeal                                                             |
      | FR       | facebook             | https://www.facebook.com/DeinDeal?brand_redir=324820927225                                    |
      | DE       | twitter              | https://twitter.com/deindeal                                                                  |
      | FR       | twitter              | https://twitter.com/deindeal                                                                  |
      | DE       | How it works         | /de/wie-funktioniert-deindeal                                                                 |
      | FR       | How it works         | /fr/comment-fonctionne-deindeal                                                               |
      | DE       | About us             | /de/uber-uns                                                                                  |
      | FR       | About us             | /fr/qui-sommes-nous                                                                           |
      | DE       | Career               | /de/karriere                                                                                  |
      | FR       | Career               | /fr/emplois                                                                                   |
      | DE       | AGB                  | /de/agb                                                                                       |
      | FR       | AGB                  | /fr/termes-et-conditions                                                                      |
      | DE       | Partner AGB          | /de/agb-partner                                                                               |
      | FR       | Partner AGB          | /fr/cgv-partenaire                                                                            |
      | DE       | Datenschutz          | /de/datenschutz                                                                               |
      | FR       | Datenschutz          | /fr/confidentialite                                                                           |
      | DE       | Impressum            | /de/impressum                                                                                 |
      | FR       | Impressum            | /fr/mentions-legales                                                                          |
      | DE       | Contact form         | /de/kontakt                                                                                   |
      | FR       | Contact form         | /fr/contacter                                                                                 |
      | DE       | FAQ                  | /de/haufig-gestellte-fragen                                                                   |
      | FR       | FAQ                  | /fr/faq                                                                                       |
      | DE       | Partner              | /de/ihre-vorteile-als-partner                                                                 |
      | FR       | Partner              | /fr/vos-avantages-en-tant-que-partenaire                                                      |
      | DE       | Partner site         | /de/partner-seiten                                                                            |
      | FR       | Partner site         | /fr/sites-partenaires                                                                         |
      | DE       | Partner contact form | /de/zusammenarbeit                                                                            |
      | FR       | Partner contact form | /fr/cooperation                                                                               |
      | DE       | Ringier logo         | http://www.ringier.com/                                                                       |
      | FR       | Ringier logo         | http://www.ringier.com/                                                                       |


  Scenario Outline: Footer channel link validation
    Given I am on "<string>" channel as an existing visitor
    And language is set to "<language>"
    And I scroll to footer
    When I click on "<string>" channel from footer
    Then I should land on correct channel

    Examples:
      | language | string         |
      | DE       | Deine Stadt    |
      | FR       | Ta ville       |
      | DE       | Extra Coupons  |
      | FR       | Extra Coupons  |
      | DE       | Home & Living  |
      | FR       | Home & Living  |
      | DE       | Electronics    |
      | FR       | Electronics    |
      | DE       | Travel         |
      | FR       | Travel         |
      | DE       | Fashion        |
      | FR       | Fashion        |
      | DE       | Kids           |
      | FR       | Kids           |
      | DE       | Sport          |
      | FR       | Sport          |
      | DE       | Wine & Gourmet |
      | FR       | Wine & Gourmet |
      | DE       | Love & Play    |
      | FR       | Love & Play    |

  Scenario Outline: Footer DeinDeal logo redirect validation
    Given I am on "any" channel as an existing visitor on "<language>"
    And language is set to "<language>"
    When I click the DeinDeal logo from footer
    Then I should land on homepage
    And language is set to "<language>"
    Examples:
      | language |
      | de       |
      | fr       |




