@AddExperience
Feature: Add Experience

  @Happy @Regression @Smoke @UI
  Scenario: Happy Path
    Given user is logged in
      | username | muradil.erkin@boratechschool.com |
      | password | Boratech                         |
    When user clicks on the add experience button
    And user enters experience info and submits
      | jobTitle    | Paw Patrol     |
      | company     | Disney Plus CA |
      | location    | California     |
      | fromDate    |       09012008 |
      | current     | false          |
      | toDate      |       06012012 |
      | description | Awesome        |
    Then the experience with the given company name should be displayed
      | company | Disney Plus CA |

  @Unhappy @Regression @UI
  Scenario Outline: Unhappy path
    Given user is logged in
      | username | muradil.erkin@boratechschool.com |
      | password | Boratech                         |
    When user clicks on the add experience button
    And user enters experience info and submits
      | jobTitle    | <jobTitle>    |
      | company     | <company>     |
      | location    | <location>    |
      | fromDate    | <fromDate>    |
      | current     | <current>     |
      | toDate      | <toDate>      |
      | description | <description> |
    Then user should see error message(s)
      | error | <error> |

    Examples: 
      | jobTitle   | company        | location   | fromDate | current | toDate   | description | error                                                         |
      |            | Disney Plus CA | California | 09012008 | false   | 06012012 | Awesome     | Title is required                                             |
      | Paw Patrol |                | California | 09012008 | false   | 06012012 | Awesome     | Company is required                                           |
      | Paw Patrol | Disney Plus CA | California |          | false   | 06012012 | Awesome     | From date is required                                         |
      |            |                | California | 09012008 | false   | 06012012 | Awesome     | Title is required, Company is required                        |
      | Paw Patrol |                | California |          | false   | 06012012 | Awesome     | From date is required, Company is required                    |
      |            |                | California |          | false   | 06012012 | Awesome     | From date is required, Company is required, Title is required |
