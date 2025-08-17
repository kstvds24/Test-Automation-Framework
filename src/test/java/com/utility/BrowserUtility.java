package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.constants.Browser;

public abstract class BrowserUtility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	Logger logger = LoggerUtility.getLogger(this.getClass());

	public BrowserUtility(WebDriver driver) {
		this.driver.set(driver);
		;// initialize instance variables
	}

	public BrowserUtility(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
		} else if (browser.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
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
			} else {
				driver.set(new ChromeDriver());
			}
		} else if (browser == Browser.EDGE) {
			if (isHeadLess) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=old");
				options.addArguments("disable-gpu");
				driver.set(new EdgeDriver(options));
			} else {
				driver.set(new EdgeDriver());
			}
		} else if (browser == Browser.FIREFOX) {
			if (isHeadLess) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=old");
				options.addArguments("disable-gpu");
				driver.set(new FirefoxDriver(options));
			} else {
				driver.set(new FirefoxDriver());
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
		logger.info("Maximizing browser window");
		driver.get().close();
	}

	public void clickonElement(By locator) {
		logger.info("Finding Element with the locator: " + locator + " and clicking it");
		driver.get().findElement(locator).click();
	}

	public void enterText(By locator, String text) {
		logger.info("Finding Element with the locator: " + locator);
		driver.get().findElement(locator).clear();
		logger.info("Element found now entering text: " + text);
		driver.get().findElement(locator).sendKeys(text);
	}

	public String getVisibleText(By locator) {
		logger.info("Finding Element with the locator: " + locator + " and finding visible text");
		return driver.get().findElement(locator).getText();
	}

	public String takeScreenShot(String name) {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver.get();
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = simpleDateFormat.format(date);
		String path = System.getProperty("user.dir") + "/screenshots/" + name + " - " + timeStamp + ".png";
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
