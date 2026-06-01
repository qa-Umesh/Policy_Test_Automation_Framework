package com.valuenable.pages;

import org.openqa.selenium.By;

import com.valuenable.constants.Browser;
import com.valuenable.utilities.BrowserUtility;
import com.valuenable.utilities.ValidationManager;

public class LoginPage extends BrowserUtility {
	private ValidationManager validationManager;

    public LoginPage(Browser browser,boolean isHeadless,ValidationManager validationManager) {

        super(browser,isHeadless);

        getURL("https://dev-platform.valuenable.in/");
    }

    private static final By EMAIL_ID_TEXTBOX_LOCATOR =
            By.xpath("//input[@type='email']");

    private static final By PASSWORD_TEXTBOX_LOCATOR =
            By.xpath("//input[@type='password']");

    private static final By LOGIN_BUTTON_LOCATOR =
            By.xpath("//button[contains(text(),'Login')]");

    private static final By POLICY_DD_LOCATOR =
            By.xpath("//li[contains(@class,'nav-item')]//a[contains(text(),'Policies')]");

    public LoginPage enterEmail(String email) {

        enterText(EMAIL_ID_TEXTBOX_LOCATOR, email);

        return this;
    }

    public LoginPage enterPassword(String password) {

        enterText(PASSWORD_TEXTBOX_LOCATOR, password);

        return this;
    }

    public HomePage clickOnLoginButton(ValidationManager validationManager) {

        clickOn(LOGIN_BUTTON_LOCATOR);

        waitForElement(POLICY_DD_LOCATOR);

        return new HomePage(getDriver(),validationManager);
    }
}