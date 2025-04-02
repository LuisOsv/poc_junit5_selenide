Feature: Calculator Tests

  Scenario: Verify SUM
    Given I navigate to "https://seleniumbase.io/apps/calculator"
    When I sum 2 and 2
    Then  the result should be 4

  Scenario: Verify MUlTIPLY
    Given I navigate to "https://seleniumbase.io/apps/calculator"
    When I multiply 2 and 2
    Then  the result should be 4