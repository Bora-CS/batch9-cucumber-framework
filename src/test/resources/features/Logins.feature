Feature: Login

  Scenario: Happy path login
    Given user is on the boratech practice site homepage
    When user navigates to the login page
    And user enters username and password
      | username | joycechen@test.com |
      | password |             123456 |
    And user clicks on the login button
    Then user should be on the dashboard page

  Scenario Outline: UnHappy path login
    Given user is on the boratech practice site homepage
    When user navigates to the login page
    And user enters username and password
      | username | <username> |
      | password | <password> |
    And user clicks on the login button
    Then user should see errors message displayed
      | error | <error> |

    Examples: 
      | username            | password | error                                                              |
      | joycechen@test.com  | abcdefg  | Invalid credentials                                                |
      | joyce@test.com      |   123456 | Invalid credentials                                                |
      | joycechen@gmail.com | 123qwe   | Invalid credentials                                                |
      |                     |   123456 | Please fill out this field.                                        |
      | joycechen@test.com  |          | Please fill out this field.                                        |
      |                     |          | Please fill out this field.                                        |
