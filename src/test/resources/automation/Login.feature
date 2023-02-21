Feature: BoraTech Login

  Scenario: Happy path login
    Given user is on the boratech practice site homepage
    When user navigates to the login page
    And user enters username - "shaoling.stouder@gmail.com"and password - "591159slS@"
    And user clicks on the login button
    Then user should be on the dashboard page
