Feature: Add Education

  Scenario: Happy Path
    Given user is logged in
      | username | joycechen@test.com |
      | password |             123456 |
    When user clicks on the add education button
    And user enters education info and submits
      | school       | BoraTech                 |
      | degree       | Automation certification |
      | fieldOfStudy | SDET                     |
      | fromDate     |                 09012008 |
      | current      | false                    |
      | toDate       |                 06012012 |
      | description  | Awesome                  |
    Then the education with the given company name should be displayed
      | school | BoraTech |

  Scenario Outline: UnHappy Path
    Given user is logged in
      | username | joycechen@test.com |
      | password |             123456 |
    When user clicks on the add education button
    And user enters education info and submits
      | school       | <school>       |
      | degree       | <degree>       |
      | fieldOfStudy | <fieldOfStudy> |
      | fromDate     | <fromDate>     |
      | current      | <current>      |
      | toDate       | <toDate>       |
      | description  | <description>  |
    Then user should see error message(s)
      | error | <error> |

    Examples: 
      | school   | degree                   | fieldOfStudy | fromDate | current | toDate   | description | error                                                                                  |
      |          | Automation certification | SDET         | 09012008 | false   | 06012012 | Awesome     | School is required                                                                     |
      | BoraTech |                          | SDET         | 09012008 | false   | 06012012 | Awesome     | Degree is required                                                                     |
      | BoraTech | Automation certification |              | 09012008 | false   | 06012012 | Awesome     | Field of study is required                                                             |
      | BoraTech | Automation certification | SDET         |          | false   | 06012012 | Awesome     | From date is required                                                                  |
      |          |                          | SDET         | 09012008 | false   | 06012012 | Awesome     | School is required,Degree is required                                                  |
      |          |                          |              | 09012008 | false   | 06012012 | Awesome     | School is required,Degree is required,Field of study is required                       |
      |          |                          |              |          | false   | 06012012 | Awesome     | School is required,Degree is required,Field of study is required,From date is required |
