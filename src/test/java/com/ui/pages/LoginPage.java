package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class LoginPage extends BrowserUtility{
	
	private static final By Email_TextBox_Locator = By.id("email");
	private static final By Password_TextBox_Locator = By.id("passwd");
	private static final By Submit_Login_Locator = By.id("SubmitLogin");
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public MyAccountPage doLoginWith(String emailAddress, String password) {
		
		
		enterText(Email_TextBox_Locator, emailAddress);
		enterText(Password_TextBox_Locator, password);
		clickOn(Submit_Login_Locator);
		MyAccountPage myAccount = new MyAccountPage(getDriver());
		return myAccount;
		}
}
