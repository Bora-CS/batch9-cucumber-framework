Feature: Amazon Search

  @UI
  Scenario Outline: Search and collect data
    Given I'm on the amazon home page
    When I search for "<searchTerm>"
    Then I should see some search results
    And I should be able to collect data about the search results

    Examples: 
      | searchTerm  |
      | iPhone Case |
