package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ShoppingCartPage extends BrowserUtility{

	private static final By PROCEED_TO_CHECKOUT_BTN_LOCATOR = By.xpath("//p[contains(@class,'clearfix')]//a[@title='Proceed to checkout']");
	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
    public ConfirmAddressPage goToConfirmAddressPage() throws InterruptedException
    {
    	clickonElement(PROCEED_TO_CHECKOUT_BTN_LOCATOR);
    	ConfirmAddressPage confirmAddressPage = new ConfirmAddressPage(getDriver());
    	return confirmAddressPage;
    }
}
