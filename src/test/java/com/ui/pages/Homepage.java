package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import static com.constants.Env.*;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;

import static com.utility.PropertiesUtil.*;

public final class Homepage extends BrowserUtility{
	
	Logger logger = LoggerUtility.getLogger(this.getClass());
	static final By Sign_In_Link_Locator = By.xpath("//a[contains(text(),\"Sign in\")]");
	
	public Homepage(Browser browser, boolean isHeadless) {
		super(browser, isHeadless);
		
		//goToWebsite(readProperties(QA, "URL"));
		goToWebsite(JSONUtility.readJSON(QA).getUrl());
		//maximizeWindow();
	}
	
	
	public Homepage(WebDriver driver) {
		super(driver);
		goToWebsite(JSONUtility.readJSON(QA).getUrl());
	}


	

	public LoginPage goToLoginPage() { //Page Functions
		logger.info("Trying to Perform click to go to Sign in Page");
		clickOn(Sign_In_Link_Locator);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}


	public void quit() {
		getDriver().quit();
		
	}
}
