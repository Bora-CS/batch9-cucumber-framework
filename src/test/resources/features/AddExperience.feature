@AddExperience
Feature: Add Experience

  @API @Happy @Unhappy @Regression @Smoke
  Scenario Outline: API Add experience
    Given [API] user is logged in
      | username                         | password |
      | muradil.erkin@boratechschool.com | Boratech |
    When [API] user tries to add an experience
      | title       | <title>       |
      | company     | <company>     |
      | location    | <location>    |
      | from        | <from>        |
      | current     | <current>     |
      | to          | <to>          |
      | description | <description> |
    Then [API] user should see a <statusCode> status code
    And [API] the response body should contain given message
      | message    |
      | <message1> |
      | <message2> |
      | <message3> |

    Examples: 
      | title      | company        | location   | from       | current | to         | description | statusCode | message1              | message2            | message3          |
      | Paw Patrol | Disney Plus CA | California | 2008-09-01 | false   | 2012-06-01 | Awesome     |        200 | Disney Plus CA        |                     |                   |
      |            | Disney Plus CA | California | 2008-09-01 | false   | 2012-06-01 | Awesome     |        400 | Title is required     |                     |                   |
      | Paw Patrol |                | California | 2008-09-01 | false   | 2012-06-01 | Awesome     |        400 | Company is required   |                     |                   |
      | Paw Patrol | Disney Plus CA | California |            | false   | 2012-06-01 | Awesome     |        400 | From date is required |                     |                   |
      |            |                | California | 2008-09-01 | false   | 2012-06-01 | Awesome     |        400 | Title is required     | Company is required |                   |
      | Paw Patrol |                | California |            | false   | 2012-06-01 | Awesome     |        400 | From date is required | Company is required |                   |
      |            |                | California |            | false   | 2012-06-01 | Awesome     |        400 | From date is required | Company is required | Title is required |

  @Happy @Regression @Smoke @UI
  Scenario: Happy Path
    Given user is logged in
      | username | muradil.erkin@boratechschool.com |
      | password | Boratech                         |
    When user clicks on the add experience button
    And user enters experience info and submits
      | title      | company        | location   | from     | to       | current | description |
      | Paw Patrol | Disney Plus CA | California | 09012008 | 06012012 | false   | Awesome     |
    Then the experience with the given company name should be displayed
      | company | Disney Plus CA |

  @Unhappy @Regression @UI
  Scenario Outline: Unhappy path
    Given user is logged in
      | username | muradil.erkin@boratechschool.com |
      | password | Boratech                         |
    When user clicks on the add experience button
    And user enters experience info and submits
      | title   | company   | location   | from   | to   | current   | description   |
      | <title> | <company> | <location> | <from> | <to> | <current> | <description> |
    Then user should see error message(s)
      | error | <error> |

    Examples: 
      | title      | company        | location   | from     | current | to       | description | error                                                         |
      |            | Disney Plus CA | California | 09012008 | false   | 06012012 | Awesome     | Title is required                                             |
      | Paw Patrol |                | California | 09012008 | false   | 06012012 | Awesome     | Company is required                                           |
      | Paw Patrol | Disney Plus CA | California |          | false   | 06012012 | Awesome     | From date is required                                         |
      |            |                | California | 09012008 | false   | 06012012 | Awesome     | Title is required, Company is required                        |
      | Paw Patrol |                | California |          | false   | 06012012 | Awesome     | From date is required, Company is required                    |
      |            |                | California |          | false   | 06012012 | Awesome     | From date is required, Company is required, Title is required |
