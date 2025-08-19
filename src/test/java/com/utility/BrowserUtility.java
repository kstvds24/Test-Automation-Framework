package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;

public abstract class BrowserUtility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private WebDriverWait wait;

	public BrowserUtility(WebDriver driver) {
		this.driver.set(driver);
		wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
		;// initialize instance variables
	}

	public BrowserUtility(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
			wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
		} else if (browser.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
			wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
		} else {
			System.err.println("Browser name is not valid......Please enter browser name chrome or edge");
		}
	}

	public BrowserUtility(Browser browser, boolean isHeadLess) {
		logger.info("Launching Browser: " + browser.name());
		if (browser == Browser.CHROME) {
			if (isHeadLess) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=new");
				options.addArguments("--window-size=1920,1080");
				options.addArguments("--no-sandbox");
				options.addArguments("--disable-dev-shm-usage");
				options.addArguments("--remote-allow-origins=*");
				driver.set(new ChromeDriver(options));
				wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
			} else {
				driver.set(new ChromeDriver());
				wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
			}
		} else if (browser == Browser.EDGE) {
			if (isHeadLess) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=old");
				options.addArguments("disable-gpu");
				driver.set(new EdgeDriver(options));
				wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
			} else {
				driver.set(new EdgeDriver());
				wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
			}
		} else if (browser == Browser.FIREFOX) {
			if (isHeadLess) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=old");
				options.addArguments("disable-gpu");
				driver.set(new FirefoxDriver(options));
				wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
			} else {
				driver.set(new FirefoxDriver());
				wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
			}
		}
	}

	public WebDriver getDriver() {
		return driver.get();
	}

	public void goToWebSite(String url) {
		logger.info("Visting the website:" + url);
		driver.get().get(url);
	}

	public void maximizeBrowser() {
		logger.info("Maximizing browser window");
		driver.get().manage().window().maximize();
	}

	public void quit() {
		logger.info("Ending Browser session");
		driver.get().quit();
	}

	public void clickonElement(By locator) {
		logger.info("Finding Element with the locator: " + locator + " and clicking it");
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		//Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}

	public void clickonElement(WebElement element) {
		logger.info("Finding Element with the locator: " + element + " and clicking it");
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	public void enterText(By locator, String text) {
		logger.info("Finding Element with the locator: " + locator);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		driver.get().findElement(locator).clear();
		logger.info("Element found now entering text: " + text);
		driver.get().findElement(locator).sendKeys(text);
	}

	public void selectFromDropdown(By locator, String optionToSelect) {
		logger.info("Finding Dropdown with the locator: " + locator);
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Select select = new Select(element);
		logger.info("Selecting option: " + optionToSelect);
		select.selectByVisibleText(optionToSelect);
	}

	public void enterSpecialKey(By locator, Keys key) {
		logger.info("Finding Element with the locator: " + locator);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		// WebElement element = driver.get().findElement(locator);
		logger.info("Element found now hitt: " + key);
		element.sendKeys(key);
	}

	public List<String> getAllVisibleText(By locator) {
		logger.info("Finding all Elements with the locator: " + locator);
		List<WebElement> elementList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		// driver.get().findElements(locator);
		logger.info("Elements entered in lis now printing the visible texts");
		List<String> allVisibleTexts = new ArrayList<String>();
		for (WebElement element : elementList) {
			// System.out.println(getVisibleText(element));
			allVisibleTexts.add(getVisibleText(element));
		}
		return allVisibleTexts;
	}

	public List<WebElement> getAllElements(By locator) {
		logger.info("Finding all Elements with the locator: " + locator);
		//wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		//List<WebElement> elementList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		 List<WebElement> elementList = driver.get().findElements(locator);

		return elementList;
	}

	public String getVisibleText(By locator) {
		logger.info("Finding Element with the locator: " + locator + " and finding visible text");
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return driver.get().findElement(locator).getText();
	}

	public String getVisibleText(WebElement element) {
		logger.info("Finding Element: " + element + " and finding visible text");
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.getText();
	}

	public String takeScreenShot(String name) {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver.get();
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = simpleDateFormat.format(date);
		String path = "./screenshots/" + name + " - " + timeStamp + ".png";
		File screenshotData = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
}
