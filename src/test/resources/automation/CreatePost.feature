Feature: Post

  Scenario: Create Post
    Given user is on the boratech practice site homepage
    When user navigates to the login page
    And user enters username - "joycechen@test.com" and password - "123456"
    And user clicks on the login button
    Then user should be on the dashboard page
    When user navigates to the posts page
    And user enters some post content and clicks on submit
      | content | Hello World! |
    Then the newly created post should be on the page
