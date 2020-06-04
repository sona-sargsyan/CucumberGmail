Feature: Email Folders Test

  @Smoke
  Scenario Outline: Test that by clicking on the folders it opens corresponding pages.
    Given user is signed in and inbox is open
    When user open <folderName> folder
    Then see <folderName> folder name in URL
    And user log out
    Examples:
      | folderName |
      | Drafts   |
      | Sent   |
      | mentoring   |