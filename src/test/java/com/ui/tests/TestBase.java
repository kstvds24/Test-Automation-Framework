package com.ui.tests;

import static com.constants.Browser.CHROME;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;
import com.utility.LoggerUtility;

public abstract class TestBase {
	protected HomePage homePage;
	private boolean isLamdaTest = true;

	Logger logger = LoggerUtility.getLogger(this.getClass());

	@Parameters({"browser","isLamdaTest","isHeadLess"})
	@BeforeMethod(description = "Load the HomePage")
	public void setup(
			@Optional("chrome")String browser,
			@Optional("false")boolean isLamdaTest, 
			@Optional("true")boolean isHeadLess,ITestResult result) {

		this.isLamdaTest = isLamdaTest;
		WebDriver lambdaDriver;
		if (isLamdaTest) {
			lambdaDriver = LambdaTestUtility.initializeLamdaTestSession("chrome", result.getMethod().getMethodName());
			homePage =new HomePage(lambdaDriver);

		} else {
			//Running the test on local machine
			logger.info("Load the Home Page of the Website");
			homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), isHeadLess);
		}
	}

	public BrowserUtility getInstance() {
		return homePage;
	}
	
	@AfterMethod(description="Tear Down the browser")
	public void tearDown()
	{
		if(isLamdaTest)
		{
			LambdaTestUtility.quitSession();
		}
		else
		{
		homePage.quit();
		}
	}
}
