@Post
Feature: Post

  @e2e @UI @API @Smoke @Regression
  Scenario Outline: Post end to end test
    Given [API] user is logged in and the user data is saved
      | username                         | password |
      | muradil.erkin@boratechschool.com | Boratech |
    And [API] user can create a post with random content
    When user is logged in
      | username | muradil.erkin@boratechschool.com |
      | password | Boratech                         |
    And user navigates to the posts page
    Then user should see a post that they created previously
    When user deletes the post that they created previously
    Then [API] user can validate that the post they created previously is not there
