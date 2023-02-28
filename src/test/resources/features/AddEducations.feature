Feature: Add Education

  Scenario Outline: Happy Path
    Given user is logged in
      | username | wenji.zou.z@gmail.com |
      | password |                123456 |
    When user clicks on the add education button
    And user enters education info and submits
      | school       | <school>       |
      | degree       | <degree>       |
      | fieldOfStudy | <fieldOfStudy> |
      | fromDate     | <fromDate>     |
      | current      | <current>      |
      | toDate       | <toDate>       |
      | description  | <description>  |
    Then the education with the given school name should be displayed
      | school | Best Academy |

    Examples: 
      | school       | degree      | fieldOfStudy | fromDate | current | toDate   | description           |
      | Best Academy | High School | General      | 09012008 | false   | 06012012 | Best time of my life! |
      | Best Academy | High School | General      | 09012008 | true    |          | Best time of my life! |
      | Best Academy | High School | General      | 09012008 | true    |          |                       |

  Scenario Outline: Unsuccesful Path
    Given user is logged in
      | username | wenji.zou.z@gmail.com |
      | password |                123456 |
    When user clicks on the add education button
    And user enters education info and submits
      | school       | <school>       |
      | degree       | <degree>       |
      | fieldOfStudy | <fieldOfStudy> |
      | fromDate     | <fromDate>     |
      | current      | <current>      |
      | toDate       | <toDate>       |
      | description  | <description>  |
    Then user should see error message(s) on the add education page
      | error | <error> |

    Examples: 
      | school       | degree      | fieldOfStudy | fromDate | current | toDate   | description           | error                      |
      |              | High School | General      | 09012008 | false   | 06012012 | Best time of my life! | School is required         |
      | Best Academy |             | General      | 09012008 | false   | 06012012 | Best time of my life! | Degree is required         |
      | Best Academy | High School |              | 09012008 | false   | 06012012 | Best time of my life! | Field of study is required |
      | Best Academy | High School | General      |          | false   | 06012012 | Best time of my life! | From date is required      |
