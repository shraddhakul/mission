package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import managers.WebDriverManager;

public class HomePage {
	
	WebDriverManager app;
	

	public HomePage(WebDriverManager app) {
		this.app = app;
	}
	
	
	
	public void load(String browser) { //open browser and navigate to home page
		app.openBrowser(browser);
		app.navigate("url");
		
	}
	
	public void goToLogin() {
		app.click("signinbtn_xp");
	}
	
	public void userSignUp() {
		app.click("signin_up_xp");
	}
	
	public void flightsClick() {
		app.click("flight_link_xp");
	}
	public void leaving_from() {
		app.type("leaving_frm_xp","start_location");
	}
	
	public void going_to() {
		app.type("going_to_xp","return_location");
	}
	
	public void depart_date() {
		app.click("from_date_xp");
	}
	
	public void return_date() {
		app.click("to_date_xp");
	}

}
