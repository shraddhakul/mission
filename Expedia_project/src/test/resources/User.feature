
@UserRegistration
Feature: User Registration
  I want to register a user on Expedia.com

  @NewUser
  Scenario: Non Registered User Verify
    Given I visit the home page
    And I click on the Sign In link
    And I click on sign up link
    Then I should should see the verification page   


