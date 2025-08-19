package com.ui.tests;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;

@Listeners(com.ui.listeners.TestListeners.class)
public class SearchProductTest extends TestBase {

	Logger logger = LoggerUtility.getLogger(this.getClass());
	private MyAccountPage myAccountPage;
	private static final String SEARCH_TEXT = "Summer Printed dress";

	@BeforeMethod(description = "Valid user logs in to the application", groups = { "e2e", "sanity" })
	public void setup() {
		myAccountPage = homePage.goToLoginPage().login(JSONUtility.getUserData().getData().get(0).getEmailAddress(),
				JSONUtility.getUserData().getData().get(0).getPassword());
	}

	@Test(description = "Verifies that user is able to search for a product and correct products are displayed in search result")
	public void VerifyProductSearch() throws InterruptedException {
		// Assert.assertEquals(myAccountPage.searchForProduct("Summer Printed
		// dress").getSearchResultTitle(),"Summer Printed dress");
		Assert.assertEquals(myAccountPage.searchForProduct(SEARCH_TEXT).getAllDressName(SEARCH_TEXT), true);
		// System.out.println(title);
	}

}
