Feature: Dynamic Table Testing

  Scenario: Verify CPU usage of Chrome in the dynamic table
    Given I navigate to "https://uitestingplayground.com/dynamictable"
    When I look for the Memory usage of "Chrome" in the dynamic table
    And I look for the Memory usage of "Firefox" in the dynamic table
    And I look for the Memory usage of "Internet Explorer" in the dynamic table