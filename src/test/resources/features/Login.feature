Feature: Login

  @Regression @Smoke @UI
  Scenario: Happy path login
    Given user is on the boratech practice site homepage
    When user navigates to the login page
    And user enters username - "wenji.zou.z@gmail.com" and password - "123456"
    And user clicks on the login button
    Then user should be on the dashboard page

  Scenario Outline: unsuccesful login
    Given user is on the boratech practice site homepage
    When user navigates to the login page
    And user enters username and password
      | username | <username> |
      | password | <password> |
    And user clicks on the login button
    Then user should see error message
      | error | <error> |

    Examples: 
      | username               | password | error               |
      | abc@boratechschool.com |   654321 | Invalid credentials |
      | abc@boratechschool.com |   123456 | Invalid credentials |
      | wenji.zou.z@gmail.com  |   654321 | Invalid credentials |
