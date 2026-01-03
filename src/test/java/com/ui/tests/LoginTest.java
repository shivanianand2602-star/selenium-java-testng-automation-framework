package com.ui.tests;

import static com.constants.Browser.*;

import static org.testng.Assert.*;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.Homepage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;

@Listeners({com.ui.listeners.TestListener.class})
public final class LoginTest extends TestBase{
	
	Logger logger = LoggerUtility.getLogger(this.getClass());
	
	

	
	@Test(description = "Verify login functionality using valid credentials",groups = {"smoke", "sanity", 
			"e2e"}, dataProviderClass = com.ui.dataprovider.LoginDataProvider.class, dataProvider = "LoginTestDataProvider")
	public void loginTest(User user) throws InterruptedException  {
				
		assertEquals(homepage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Shivani Anand");
		
	}
/*	
	@Test(description = "Verify login functionality using valid credentials",groups = {"smoke", "sanity", 
	"e2e"}, dataProviderClass = com.ui.dataprovider.LoginDataProvider.class, dataProvider = "loginTestCSVDataProvider")
public void loginCSVTest(User user) throws InterruptedException  {
		
assertEquals(homepage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Shivani Anand");

}

	
	
	@Test(description = "Verify login functionality using valid credentials",groups = {"smoke", "sanity", 
	"e2e"}, dataProviderClass = com.ui.dataprovider.LoginDataProvider.class, dataProvider = "loginTestExcelDataProvider", 
	retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
public void loginExcelTest(User user) throws InterruptedException  {
		
		
		assertEquals(homepage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Shivani Anand1");
		
}
*/
	
}
