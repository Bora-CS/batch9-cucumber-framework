Feature: Delete Post

  Scenario: delete Post
    Given user is on the boratech practice site homepage
    When user navigates to the login page
    And user enters username - "joycechen@test.com" and password - "123456"
    And user clicks on the login button
    Then user should be on the dashboard page
    When user navigates to the posts page
    And delete the post according to post content
      | content | This is test-6 |
    Then verify user delete the post successfully
