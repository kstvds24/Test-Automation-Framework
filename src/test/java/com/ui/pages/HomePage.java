package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.constants.ENV;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;

public final class HomePage extends BrowserUtility {
	Logger logger = LoggerUtility.getLogger(this.getClass());
	public HomePage(Browser browser,boolean isHeadLess) {
		super(browser,isHeadLess);

		goToWebSite(JSONUtility.readjson(ENV.QA).getUrl());
	}
public HomePage(WebDriver driver)
{
	super(driver);
	goToWebSite(JSONUtility.readjson(ENV.QA).getUrl());
}
	private static final By SIGN_IN_LINK = By.xpath("//a[contains(text(),'Sign in')]");

	public LoginPage goToLoginPage() {
		logger.info("Trying to click on SignIn Link");
		clickonElement(SIGN_IN_LINK);
		return new LoginPage(getDriver());
	}

}
