package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojos.AddressPOJO;
import com.utility.FakerUitility;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;

@Listeners(com.ui.listeners.TestListeners.class)
public class AddNewAddressTest extends TestBase {

	Logger logger = LoggerUtility.getLogger(this.getClass());
	private MyAccountPage myAccountPage;
	private AddressPOJO address;

	@BeforeMethod(description = "Valid user logs in to the application", groups = { "e2e", "sanity" })
	public void setup() {
		myAccountPage = homePage.goToLoginPage().login(JSONUtility.getUserData().getData().get(0).getEmailAddress(),
				JSONUtility.getUserData().getData().get(0).getPassword());
		address = FakerUitility.getFakerAddress();
		// addressPOJO = new AddressPOJO("CTS", "123 king", "Street", "NYC"
		// ,"7686923754", "7686923755", "23456", "other", "Home Address", "Alabama");
	}

	@Test(description = "Verifies that user is able to add new address")
	public void VerifyUserIsAbleToAddNewAddress() throws InterruptedException {
		Assert.assertEquals(myAccountPage.goToAddNewAddress().saveAddress(address), address.getAddressTitle().toUpperCase());
				
	}

}
