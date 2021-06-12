package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LandingPage;
import pages.LoginPage;

public class LoginTest {
	
	@Test
	public void doLogin() {
		System.setProperty("webdriver.chrome.driver", "C:\\eclipse-workspace\\Test\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		HomePage homePage = new HomePage(driver);
		LoginPage loginPage = homePage.goToLoginPage();
		LandingPage landingPage = loginPage.doLogin("crazy.traveller@gmail.com","globetrotter");
		
	}

}
