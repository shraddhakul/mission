package context;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import managers.PageObjectManager;
import reports.ExtentManager;

public class TestContext {
	
	ExtentReports report;
	ExtentTest test;
	public String basePath = System.getProperty("user.dir")+"\\reports\\";
	
	private PageObjectManager pageObjectManager;
	
	
	public TestContext() {
		System.out.println("Inside constructor TestContext");
		report = ExtentManager.getReport(basePath); 
		//test = report.createTest(null)
		this.pageObjectManager= new PageObjectManager();
	}
	
	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;	
	}
	
	public void createScenario(String scenarioName) {
		test = report.createTest(scenarioName);
	}
	
	public void endScenario() {
		report.flush();
	}
	
	public void log(String msg) {
		test.log(Status.INFO,msg);
	}

}
