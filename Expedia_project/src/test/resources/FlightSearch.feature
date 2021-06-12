


@Flights
Feature: Round Trip Flight Search
  Flight serach for round trips

  @FlightSearch
  Scenario Outline: Round Trip Flight Search
   
    Given I am on the Home page
    And I click on flights option
    When I fill in Leaving from
    And I fill in Going to
    And I select Departing Date
    And I select Returning Date
    And I click on search button
    Then I should see the Covid-19 travel alert
    Then I should see search result with matching search details
    And There should be a select button visible

 
