package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ConfirmOrderPage extends BrowserUtility {

	private static final By CONFIRM_ORDER_BUTTON_LOCATOR = By
			.xpath("//span[text()='I confirm my order']/parent::button");
	private static final By SUCCESS_ALERT_MSG_LOCATOR = By.xpath("//p[@class=\"alert alert-success\"]");

	public ConfirmOrderPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public String confirmTheOrder() {
		clickonElement(CONFIRM_ORDER_BUTTON_LOCATOR);
		return getVisibleText(SUCCESS_ALERT_MSG_LOCATOR);
	}

}
