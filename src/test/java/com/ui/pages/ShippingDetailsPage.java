package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ShippingDetailsPage extends BrowserUtility{

	private static final By TERMS_OF_SERVICE_CHECKBOX_LOCATOR = By.id("uniform-cgv");
	private static final By PROCEED_TO_CHECKOUT_BUTTON = By.name("processCarrier");
	public ShippingDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public ShippingDetailsPage checkTermsOfServiceCheckBox()
	{
		clickonElement(TERMS_OF_SERVICE_CHECKBOX_LOCATOR);
		return this;
	}
	public PaymentPage navigateToPaymentsPage()
	{
		clickonElement(PROCEED_TO_CHECKOUT_BUTTON);
		return new PaymentPage(getDriver());
	}
   
}
