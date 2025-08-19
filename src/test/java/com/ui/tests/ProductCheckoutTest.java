package com.ui.tests;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.constants.SIZE;
import com.ui.pages.SearchResultPage;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;

@Listeners(com.ui.listeners.TestListeners.class)
public class ProductCheckoutTest extends TestBase {

	Logger logger = LoggerUtility.getLogger(this.getClass());
	private SearchResultPage searchResultPage;
	private static final String SEARCH_TEXT = "Summer Printed dress";

	@BeforeMethod(description = "Valid user logs in to the application and searches for a product", groups = { "e2e",
			"sanity" })
	public void setup() throws InterruptedException {
		searchResultPage = homePage.goToLoginPage().login(JSONUtility.getUserData().getData().get(0).getEmailAddress(),
				JSONUtility.getUserData().getData().get(0).getPassword()).searchForProduct(SEARCH_TEXT);
	}

	@Test(description = "Verifies that user is able to buy the product")
	public void VerifyUserIsABleToBuyAProduct() throws InterruptedException {
		Assert.assertEquals(
				searchResultPage.clickOnTheFirstItem().selectSizeAndCheckout(SIZE.M).addToCart().proceedToCheckOut()
						.goToConfirmAddressPage().goToShippingDetailsPage().checkTermsOfServiceCheckBox()
						.navigateToPaymentsPage().proceedToConfirmOrderPage().confirmTheOrder(),
				"Your order on My Shop is complete.");
	}

}
