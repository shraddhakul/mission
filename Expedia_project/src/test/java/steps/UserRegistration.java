package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import managers.WebDriverManager;
import pages.HomePage;

public class UserRegistration {
	
	public TestContext context;
	public HomePage homepage;
	

	
	public UserRegistration(TestContext context) {
		this.context=context;
		this.homepage = this.context.getPageObjectManager().getHomePage();
	}
	
	@Given("I visit the home page")
	public void visit_homepage() {
	context.log("Visitng home page");
	homepage.load("Chrome");
	}
	
	@Given("I click on the Sign In link")
	public void click_signIn() {
		context.log("click on sign in link");
		homepage.goToLogin();
		}
	@Given("I click on sign up link")
	public void click_signUp() {
		context.log("click on sign up link");
		homepage.userSignUp();
	}
	@Then("I should should see the verification page")
	public void human_verification() {
		context.log("Verify you are human");
	}

}
