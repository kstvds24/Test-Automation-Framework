package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pojos.Users;
import com.utility.LoggerUtility;

@Listeners(com.ui.listeners.TestListeners.class)
public class LoginTest3 extends TestBase {
	Logger logger = LoggerUtility.getLogger(this.getClass());

	@Test(description = "Verifies if valid user is able to login into the application", groups = { "e2e",
			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestDataProvider")
	public void LoginTest(Users users) {
		assertEquals(homePage.goToLoginPage().login(users.getEmailAddress(), users.getPassword()).getUserName(),
				"Kaustav Das");

	}

//	@Test(description = "Verifies if valid user is able to login into the application", groups = { "e2e",
//			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestCSVDataProvider")
//	public void LoginTestCSVData(Users users) {
//		assertEquals(homePage.goToLoginPage().login(users.getEmailAddress(), users.getPassword()).getUserName(),
//				"Kaustav Das");
//
//	}
//
//	@Test(description = "Verifies if valid user is able to login into the application", groups = { "e2e",
//			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestExcelDataProvider", retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
//	public void LoginTestExcelData(Users users) {
//		Logger logger = LoggerUtility.getLogger(this.getClass());
//		logger.info("Started Login Excel Test ");
//		assertEquals(homePage.goToLoginPage().login(users.getEmailAddress(), users.getPassword()).getUserName(),
//				"Kaustav Das");
//		logger.info("Login Excel Test Completed");
//
//	}

}
