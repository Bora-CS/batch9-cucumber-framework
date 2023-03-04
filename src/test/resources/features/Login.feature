@Login
Feature: Login

  @API @Regression @Smoke @Happy
  Scenario: Happy path API login
    Given [API] user is logged in
      | username                         | password |
      | muradil.erkin@boratechschool.com | Boratech |

  @API @Regression @Unhappy
  Scenario Outline: Unhappy path API login
    Given [API] user tries to login
      | username   | password   |
      | <username> | <password> |
    Then [API] user should see a <statusCode> status code
    And [API] the response body should contain given message
      | message   |
      | <message> |

    Examples: 
      | username                            | password    | statusCode | message             |
      | muradil.erkin@boratechschool.com    | Boratech123 |        400 | Invalid credentials |
      | muradil.erkin123@boratechschool.com | Boratech    |        400 | Invalid credentials |
      | muradil.erkin@hello                 | Boratech    |        400 | Invalid email       |

  @UI @Regression @Smoke @Happy
  Scenario: Happy path login
    Given user is on the boratech practice site homepage
    When user navigates to the login page
    And user enters username - "muradil.erkin@boratechschool.com" and password - "Boratech"
    And user clicks on the login button
    Then user should be on the dashboard page

  @UI @Regression @Unhappy
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
