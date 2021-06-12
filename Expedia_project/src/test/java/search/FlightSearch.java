package search;

import context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;


public class FlightSearch {
	
	public TestContext context;
	HomePage homepage;
	
	public FlightSearch(TestContext context) {
		this.context=context;
		this.homepage = this.context.getPageObjectManager().getHomePage();
	}
	
	@Before
	public void before(Scenario scenario) {
		
		context.createScenario(scenario.getName());
		context.log("startin scenario: "+scenario.getName());
		
	}
	
	@After
	public void after(Scenario scenario) {
		
		context.log("Ending scenario: "+scenario.getName());
		context.endScenario();
		
		
	}
	
	@Given("I am on the Home page")
	public void home_page() {
	   context.log("I am on the home page");
		homepage.load("Chrome");
	}
	
	@Given("I click on flights option")
	public void flights_click() {
		context.log("clicking on the flights options");
		homepage.flightsClick();
	}
	@When("I fill in Leaving from")
	public void leaving_from() {
		context.log("Leaving from");
		homepage.leaving_from();
	}
	@When("I fill in Going to")
	public void going_to() {
		context.log("Going to");
		homepage.going_to();
	}
	@When("I select Departing Date")
	public void departing_date() {
		context.log("Departure Date");
	}
	@When("I select Returning Date")
	public void returning_date() {
		context.log("Return Date");
	}
	@When("I click on search button")
	public void search_click() {
		context.log("clicking on search");
	}
	@Then("I should see the Covid-{int} travel alert")
	public void covid_alert(Integer int1) {
		context.log("covid alert");
	}
	@Then("I should see search result with matching search details")
	public void results_verify() {
		context.log("results verify");
	}
	@Then("There should be a select button visible")
	public void select_button_verify() {
		context.log("select button click verify");
	}

}
