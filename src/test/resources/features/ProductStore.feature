Feature: Shopping Cart Testing

  Scenario: Verify Shopping Cart
    Given I navigate to "https://www.demoblaze.com/index.html"
    When I add one product to shopping cart
    And I go to shopping cart page