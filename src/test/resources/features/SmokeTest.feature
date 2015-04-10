Feature: Deindeal Smoketest

  @SnokeTest
  Scenario: Deindeal Smoketest
    Given I am on the homepage
    When I click the login button
    When I enter a "random" collection
    And Sign in to the newsletter with a new email address from the new user popup
    And Register user with a new email address
    And Add a product to the cart
    And Add a coupon to the cart
    And Navigate to the live channel
    And Navigate to the checkout page
    And Place an order with any payment method
    And Validate the coupons from My Account
    And Validate the orders from My Account
    And Logout
    And Add a product to the cart unregistered
    And Navigate to the checkout page unregistered
    And Register as an existing user on checkout
    And Register as a new user on checkout
    And Place an order with any invalid payment method
    And Validate the live page
    And Only the expected channels should be visible in rd.js