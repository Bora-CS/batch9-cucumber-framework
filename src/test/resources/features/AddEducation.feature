Feature: Add Education

  @API @Happy @Unhappy @Regression @Smoke
  Scenario Outline: API Add experience
    Given [API] user is logged in
      | username                         | password |
      | muradil.erkin@boratechschool.com | Boratech |
    When [API] user tries to add an education
      | school   | degree   | fieldofstudy   | from   | to   | current   | description   |
      | <school> | <degree> | <fieldofstudy> | <from> | <to> | <current> | <description> |
    Then [API] user should see a <statusCode> status code

    Examples: 
      | school       | degree                  | fieldofstudy            | from       | to         | current | description | statusCode |
      | A Cloud Guru | AWS Certified Developer | AWS Certified Developer | 2021-06-10 | 2021-07-10 | false   |             |        200 |
      |              | AWS Certified Developer | AWS Certified Developer | 2021-06-10 | 2021-07-10 | false   |             |        400 |
