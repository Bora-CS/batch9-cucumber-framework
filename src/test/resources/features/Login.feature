@Login
Feature: Login

  @Regression @Smoke @UI @Happy
  Scenario: Happy path login
    Given user is on the boratech practice site homepage
    When user navigates to the login page
    And user enters username - "muradil.erkin@boratechschool.com" and password - "Boratech"
    And user clicks on the login button
    Then user should be on the dashboard page

  @Regression @UI @Unhappy
  Scenario Outline: Unhappy path login
    Given user is on the boratech practice site homepage
    When user navigates to the login page
    And user enters username - "<username>" and password - "<password>"
    And user clicks on the login button
    Then user should see an error alert with the message - "<errorMessage>"

    Examples: 
      | username                            | password    | errorMessage        |
      | muradil.erkin123@boratechschool.com | Boratech    | Invalid credentials |
      | muradil.erkin@boratechschool.com    | Boratech123 | Invalid credentials |
      | muradil.erkin@hello                 | Boratech123 | Invalid email       |
