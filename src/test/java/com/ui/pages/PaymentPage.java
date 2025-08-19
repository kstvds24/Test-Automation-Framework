package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class PaymentPage extends BrowserUtility {

	private static final By PAYMENT_BY_WIRE_BUTTON_LOCATOR = By.xpath("//a[@title=\"Pay by bank wire\"]");

	public PaymentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public ConfirmOrderPage proceedToConfirmOrderPage()
    {
    	clickonElement(PAYMENT_BY_WIRE_BUTTON_LOCATOR);
    	ConfirmOrderPage confirmOrderPage = new ConfirmOrderPage(getDriver());
    	return confirmOrderPage;
    }
}
