package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public LandingPage doLogin(String username,String password) {
		
		driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
		driver.findElement(By.xpath("//input[@id='signin-loginid']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='signin-password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@id='submitButton']")).click();
		
		
		return new LandingPage(driver);
		
	}

}
