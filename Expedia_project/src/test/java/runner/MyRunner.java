package runner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "C:\\eclipse-workspace\\Test\\src\\test\\resources\\",
		glue = {"steps", "search"},
		plugin = {"html:target/cucumber-reports.html"}
		//tags = "@FlightSearch"
		
		)

public class MyRunner extends AbstractTestNGCucumberTests {
	


	
	

}
