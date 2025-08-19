package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.pojos.AddressPOJO;
import com.utility.BrowserUtility;

public class AddressPage extends BrowserUtility {
	private static final By COMPANT_TXT_BOX_LOCATOR = By.id("company");
	private static final By ADDRESS1_TXT_BOX_LOCATOR = By.id("address1");
	private static final By ADDRESS2_TXT_BOX_LOCATOR = By.id("address2");
	private static final By CITY_TXT_BOX_LOCATOR = By.id("city");
	private static final By STATE_DRPDWN_LOCATOR = By.id("id_state");
	private static final By ZIP_TXT_BOX_LOCATOR = By.id("postcode");
	private static final By HOMEPHN_TXT_BOX_LOCATOR = By.id("phone");
	private static final By MOBILEPHN_TXT_BOX_LOCATOR = By.id("phone_mobile");
	private static final By ADDITIONAL_INFO_TXT_AREA_LOCATOR = By.id("other");
	private static final By ADDRESS_TITLE_TXT_BOX_LOCATOR = By.id("alias");
	private static final By SAVE_BTN_LOCATOR = By.id("submitAddress");
	private static final By ADDRESS_HEADER_LOCATOR = By.tagName("h3");

	public AddressPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public String saveAddress(AddressPOJO addressPOJO) {
    	enterText(COMPANT_TXT_BOX_LOCATOR, addressPOJO.getCompanyName());
    	enterText(ADDRESS1_TXT_BOX_LOCATOR, addressPOJO.getAddressLine1());
    	enterText(ADDRESS2_TXT_BOX_LOCATOR, addressPOJO.getAddressLine2());
    	enterText(HOMEPHN_TXT_BOX_LOCATOR, addressPOJO.getHomePhoneNumber());
    	enterText(MOBILEPHN_TXT_BOX_LOCATOR, addressPOJO.getMobilePhoneNumber());
    	enterText(CITY_TXT_BOX_LOCATOR, addressPOJO.getCity());
    	enterText(ZIP_TXT_BOX_LOCATOR, "24567");
    	enterText(ADDITIONAL_INFO_TXT_AREA_LOCATOR, addressPOJO.getAdditionalInfo());
    	enterText(ADDRESS_TITLE_TXT_BOX_LOCATOR, addressPOJO.getAddressTitle());
    	selectFromDropdown(STATE_DRPDWN_LOCATOR, addressPOJO.getState());
    	clickonElement(SAVE_BTN_LOCATOR);
    	return getVisibleText(ADDRESS_HEADER_LOCATOR);
    }

}
