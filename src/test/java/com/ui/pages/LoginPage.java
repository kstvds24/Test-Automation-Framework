package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class LoginPage extends BrowserUtility{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	
	}
	private static final By EMAIL_TEXT_BOX_LOCATOR = By.id("email");
	private static final By PASSWORD_TEXT_BOX_LOCATOR = By.id("passwd");
	private static final By LOGIN_BUTTON_LOCATOR = By.id("SubmitLogin");
	private static final By INVALID_CREDS_ERROR_MSG = By.xpath("//div[contains(@class,'alert-danger')]//ol//li");
	
	public MyAccountPage login(String userName, String password)
	{
		enterText(EMAIL_TEXT_BOX_LOCATOR, userName);
		enterText(PASSWORD_TEXT_BOX_LOCATOR, password);
		clickonElement(LOGIN_BUTTON_LOCATOR);
		return (new MyAccountPage(getDriver()));
	}
	public LoginPage loginWithInvalidCreds(String userName, String password)
	{
		enterText(EMAIL_TEXT_BOX_LOCATOR, userName);
		enterText(PASSWORD_TEXT_BOX_LOCATOR, password);
		clickonElement(LOGIN_BUTTON_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}
	public String getErrorMsg()
	{
		return getVisibleText(INVALID_CREDS_ERROR_MSG);
		
	}

}
