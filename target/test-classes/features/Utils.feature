Feature: Various steps for helpers

  @utils
  Scenario: There be dragons
    Given I login into staging "1"


  Scenario: Add a product to the cart
    Given I login into staging "1"
    Given I am on a product collection page
    When I press to "Add to cart" button - div[id^="addToCart"]
    Then I should see the cart
    And the item should be last