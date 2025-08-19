package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.utility.LoggerUtility;

@Listeners(com.ui.listeners.TestListeners.class)
public class LoginTestForInvalidCreds extends TestBase {
	private static final String WRONG_USERNAME = "kstvds61@gmail.com";
	private static final String WRONG_PASSWORD = "password1234";
	Logger logger = LoggerUtility.getLogger(this.getClass());

	@Test(description = "Verifies proper error message is displayed on entering wrong credentials", groups = { "e2e",
			"sanity" })
	public void LoginTestWithInvalidCreds() {
		assertEquals(homePage.goToLoginPage().loginWithInvalidCreds(WRONG_USERNAME, WRONG_PASSWORD).getErrorMsg(),
				"Authentication failed.");

	}

}
