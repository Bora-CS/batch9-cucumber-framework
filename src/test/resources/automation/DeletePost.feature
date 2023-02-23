Feature: Post

  Scenario: Delete Post
    Given user is on the boratech practice site homepage
    When user navigates to the login page
    And user enters username - "subhinur.muhammadd@gmail.com" and password - "Subhinur229!"
    And user clicks on the login button
    Then user should be on the dashboard page
    When user navigates to the posts page
    And user enters some post content and clicks on submit
      | content | You are awesome! |
    Then the newly created post should be on the page
    And the post content newly entered will be deleted
    And make sure the post is deleted 
    
