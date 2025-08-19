package com.ui.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class SearchResultPage extends BrowserUtility{
	
	public static final By PRODUCT_LISTING_TITLE_LOCATOR = By.xpath("//span[@class='lighter']");
	private static final By ALL_PRODUCT_LIST_NAME = By.xpath("//h5[@itemprop='name']/a");

	public SearchResultPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
    public String getSearchResultTitle() throws InterruptedException
    {
    	//Thread.sleep(3000);;
    	return getVisibleText(PRODUCT_LISTING_TITLE_LOCATOR);
    }
    public boolean getAllDressName(String searchTerm)
    {
    	List<String> allProductNames = getAllVisibleText(ALL_PRODUCT_LIST_NAME);
    	List<String> searchKeys = Arrays.asList(searchTerm.toLowerCase().split(" "));
    	boolean result =allProductNames.stream().anyMatch(name ->(searchKeys.stream().anyMatch(key -> name.toLowerCase().contains(key))));
    	return result;
    }
    public ProductDetailsPage clickOnTheFirstItem()
    {
    	clickonElement(getAllElements(ALL_PRODUCT_LIST_NAME).get(0));
    	ProductDetailsPage productDetailsPage = new ProductDetailsPage(getDriver());
    	return productDetailsPage;
    	
    }
}
