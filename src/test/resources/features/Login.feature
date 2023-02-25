Feature: Login

  Scenario: Happy path login
    Given user is on the boratech practice site homepage
    When user navigates to the login page
    And user enters username - "muradil.erkin@boratechschool.com" and password - "Boratech"
    And user clicks on the login button
    Then user should be on the dashboard page
