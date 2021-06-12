package managers;

import pages.HomePage;

public class PageObjectManager {
	
	HomePage homePage;
	WebDriverManager app;
	
	public PageObjectManager() {
		this.app= new WebDriverManager();
	}
	
	public HomePage getHomePage() {
		if(homePage==null)
			homePage = new HomePage(app);
		return homePage;
	}

}
