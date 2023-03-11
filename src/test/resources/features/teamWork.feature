Feature: Automate our first manul test

 @done @ui
  Scenario: Team 1
    Given user is logged in
      | username | muradil.erkin@boratechschool.com |
      | password | Boratech                         |
    When user navigates to the posts page
    And user find a specific post and thumbs up
      | username | Muradil Erkin |
      | content  | Hello World!960801 |
    Then user should able to see the number 1 in this content
    And user find a specific post and thumbs down
      | username | Muradil Erkin |
      | content  | Hello World!960801 |
    Then user should able to see there is no number in this content

  Scenario: Team 2
    Given user is logged in
      | username | muradil.erkin@boratechschool.com |
      | password | Boratech                         |
    When user navigates to the posts page
    And user enters some post content and clicks on submit
      | content | Hello team 2! |
    Then the newly created post should be on the page
    And user submit a post without content
    Then user should see a alert in the post page "Please fill out the feild"

  Scenario Outline: Team 3
    Given user is logged in
      | username | muradil.erkin@boratechschool.com |
      | password | Boratech                         |
    When user clicks on the add education button
    Then user enter education info
      | school   | degress   | filed of study   |
      | <school> | <degress> | <filed of study> |
    Then verify the education info is been added
      | school   | someData |
    Then delete the duection info
      | school   | someData |

    Examples: 
      | school   | degress  | filed of study   |
      | someData | someData | someData         |
      | someData | someData | someData         |
      | someData | someData | someData         |
