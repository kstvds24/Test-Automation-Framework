package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.SIZE;
import com.utility.BrowserUtility;

public class ProductDetailsPage extends BrowserUtility{

	private static final By SIZE_DROPDOWN_LOCATOR = By.id("group_1");
	private static final By ADD_TO_CART_BTN_LOCATOR = By.xpath("//span[contains(text(),'Add to cart')]//parent::button");
	private static final By PROCEED_TO_CHECKOUT_BTN_LOCATOR = By.xpath("//a[@title='Proceed to checkout']");
	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public ProductDetailsPage selectSizeAndCheckout(SIZE size)
	{
		selectFromDropdown(SIZE_DROPDOWN_LOCATOR, size.toString());
		//clickonElement(ADD_TO_CART_BTN_LOCATOR);
		return this;
	}
	public ProductDetailsPage addToCart() throws InterruptedException
	{
		clickonElement(ADD_TO_CART_BTN_LOCATOR);
		return this;
	}
	public ShoppingCartPage proceedToCheckOut() throws InterruptedException
	{
		clickonElement(PROCEED_TO_CHECKOUT_BTN_LOCATOR);
		ShoppingCartPage shoppingCartPage = new ShoppingCartPage(getDriver());
		return shoppingCartPage;
	}

}
