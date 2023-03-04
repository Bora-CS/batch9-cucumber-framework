@Post
Feature: Post

  @Regression @Smoke @API @Happy
  Scenario: Create Post API
    Given [API] user is logged in
      | username                         | password |
      | muradil.erkin@boratechschool.com | Boratech |
    Then [API] user can create a post
      | content | Hello World! |

  @Regression @Smoke @UI @Happy
  Scenario: Create Post
    Given user is logged in
      | username | muradil.erkin@boratechschool.com |
      | password | Boratech                         |
    When user navigates to the posts page
    And user enters some post content and clicks on submit
      | content | Hello World! |
    Then the newly created post should be on the page
