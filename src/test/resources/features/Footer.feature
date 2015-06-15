Feature: This is the footer of our website

  Scenario Outline: Trusted eshop icon and link validation
    Given I am on the homepage as an existing visitor on "<language>"
    And language is set to "<language>"
    And I scroll to footer
    When I click on trusted shop icon
    Then I should land on "<page link>"
    Examples:
      | language | page element    | page link                                                                                     |
      | DE       | trustedshop     | https://www.trustedshops.de/shop/certificate.php?shop_id=%20X7876D2C94CAF46E8663D48F4331D653A |
      | FR       | trustedshop     | https://www.trustedshops.de/shop/certificate.php?shop_id=%20X7876D2C94CAF46E8663D48F4331D653A |
      | DE       | swissgarantie   | http://www.vsv-versandhandel.ch/                                                              |
      | FR       | swissgarantie   | http://www.vsv-versandhandel.ch/                                                              |
      | DE       | iosdownload     | https://itunes.apple.com/ch/app/deindeal/id465657999?mt=8                                     |
      | FR       | iosdownload     | https://itunes.apple.com/fr/app/deindeal/id465657999?mt=8                                     |
      | DE       | androiddownload | https://play.google.com/store/apps/details?id=ch.deindeal.android&hl=de                       |
      | FR       | androiddownload | https://play.google.com/store/apps/details?id=ch.deindeal.android&hl=fr                       |
      | DE       | googleplus      | https://plus.google.com/+DeindealCh1/posts                                                    |
      | FR       | googleplus      | https://plus.google.com/+DeindealCh1/posts                                                    |
      | DE       | facebook        | https://www.facebook.com/DeinDeal                                                             |
      | FR       | facebook        | https://www.facebook.com/DeinDeal?brand_redir=324820927225                                    |
      | DE       | twitter         | https://twitter.com/deindeal                                                                  |
      | FR       | twitter         | https://twitter.com/deindeal                                                                  |




    Given I am on "<string>" channel as an existing visitor


