package managers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.util.Assert;






public class WebDriverManager {
	
	WebDriver driver;
	Properties prop;
	WebDriverWait wait;
	ExtentTest test;
	
	public WebDriverManager(){
		//init the properties file
		try {
		prop = new Properties();
		String path = System.getProperty("user.dir")+"\\src\\test\\resources\\project.properties";
		FileInputStream fs = new FileInputStream(path);
		prop.load(fs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void openBrowser(String browserName) {
		
		String fireFpath = System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe";
		System.setProperty("webdriver.chrome.driver", fireFpath);
		
		String chroPath = System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chroPath);
		
		String iEpath = System.getProperty("user.dir")+"\\Drivers\\IEDriverServer.exe";
		System.setProperty("webdriver.ie.driver", iEpath );
		
		if(browserName.equals("Mozilla")) {
			driver= new FirefoxDriver();
		
			}
		else if(browserName.equals("Chrome")) {
			driver= new ChromeDriver();
			}
		else if(browserName.equals("IE")) {
			driver= new InternetExplorerDriver();
			}
	}
	
	public By getLocator(String locatorKey) {
		if(locatorKey.endsWith("_xp")) {
			return By.xpath(getProperty(locatorKey));
		}
		if(locatorKey.endsWith("_id")) {
			return By.id(getProperty(locatorKey));
		}
		if(locatorKey.endsWith("_name")) {
			return By.name(getProperty(locatorKey));
		}
		else
			return By.cssSelector(getProperty(locatorKey));
	}
	
	public WebElement findElement(String locatorKey) {
		By locator = getLocator(locatorKey);
		WebElement e = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			e = driver.findElement(locator);
		}catch(Exception ex) {
			//report failure
			logFailure("Object not Found "+ locatorKey);
		}
	
		return e;
		
	}
	
	public List findElements(String locatorKey) {
		By locator = getLocator(locatorKey);
		List<WebElement> options = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			options = driver.findElements(locator);
		}catch(Exception ex) {
			//report failure
			logFailure("Object not Found "+ locatorKey);
		}
	
		return options;
		
	}
	
	public void navigate(String urlKey) {
		driver.get(getProperty(urlKey));
	}
	
	public void click(String locatorKey) {
		
		findElement(locatorKey).click();
	}
	
	public void type(String locatorKey, String data) {
		findElement(locatorKey).sendKeys(getProperty(data));
	}
	
	public void selectLocation(String locatorKey) {
		List<WebElement> options = findElements(locatorKey);
		for(WebElement option : options) {
			String st_loc = getProperty(locatorKey);
			if(option.getText().equalsIgnoreCase(getProperty(st_loc))){
				option.click();
			}
			
		}

	}
	
	/****************validation Functions*******/
	
	
	/********************** Utility functions*******************/
	
	
	public void init(ExtentTest test) {
		this.test=test;
	}
	
	public String getProperty(String key) {
		
		return prop.getProperty(key);
	}
	
	public void log(String msg) {
		test.log(Status.INFO,msg);
		
	}
	
	public void logFailure(String msg) {
		//fail in extent reports
		test.log(Status.FAIL, msg);
		//screenshot of the page and embed in the reports
	}
		
	
	

}
