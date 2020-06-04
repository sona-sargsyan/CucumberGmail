#Feature: Draft Email Test
#
#  Background:
#      Given user is signed in and inbox is open
#
#  @Smoke
#  Scenario: Test that email stored in the Draft folder, and can be sent from Draft state.
#    Given user compose an email, save and close it
#    When user open "Drafts" folder
#    And clicks on the first draft email
#    Then see recipient, subject and message
#    When user send email from draft
#    Then see draft folder is empty
#    When user open "Sent" folder
#    And click on the first send email
#    Then see recipient, subject and message in email details
#    And user log out