package com.valuenable.test;

import static com.valuenable.constants.Browser.CHROME;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.valuenable.pages.LoginPage;
import com.valuenable.utilities.ValidationManager;

public abstract class BaseTest {
	
	protected LoginPage login;
	protected ValidationManager validationManager;
	
	@BeforeMethod
	public void setUp() {
		validationManager =
	            new ValidationManager();
		login = new LoginPage(CHROME,false,validationManager);
	}
	
	@AfterMethod
	public void quite() {
		login.quiteBrowser();
	}
	

}
