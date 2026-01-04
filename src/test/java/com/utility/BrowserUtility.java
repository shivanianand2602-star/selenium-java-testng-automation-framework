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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import com.constants.Browser;

public abstract class BrowserUtility {

	private static ThreadLocal <WebDriver> driver = new ThreadLocal<WebDriver>();
	Logger logger = LoggerUtility.getLogger(this.getClass());
	
	
	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
	}
	
	public BrowserUtility(String browserName) {
		logger.info("Launching browser for" + browserName);
		if(browserName.equalsIgnoreCase("chrome")) {
			
			driver.set(new ChromeDriver());
		}
		else if(browserName.equalsIgnoreCase("safari")) {
			driver.set(new SafariDriver());
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
		}
		else if(browserName.equalsIgnoreCase("Firefox")) {
			driver.set(new FirefoxDriver());
		}
		else {
			logger.error("Invalid Browser Name" + browserName);
			System.err.println("Invalid Browser Name! Please select chrome or edge only");
		}
	}
	
	public BrowserUtility(Browser browserName) {
		logger.info("Launching browser for" + browserName);
		
		if(browserName==Browser.CHROME) {
			driver.set(new ChromeDriver());
			}
		
		else if(browserName==Browser.EDGE) {
			driver.set(new EdgeDriver());
			}
			
		else if(browserName==Browser.SAFARI) {
				driver.set(new SafariDriver());
			}
		else if(browserName==Browser.FIREFOX) {
				driver.set(new FirefoxDriver());
					
		}}
	
	public BrowserUtility(Browser browserName, boolean isHeadless) {
		logger.info("Launching browser for" + browserName);
		
		if(browserName==Browser.CHROME) {
			if(isHeadless) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless=new");
			options.addArguments("--window-size=1920,1080");
			driver.set(new ChromeDriver(options));
			}
			else {
				driver.set(new ChromeDriver());
			}
		}
		else if(browserName==Browser.EDGE) {
			if(isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=old");
				options.addArguments("disable-gpu");
				driver.set(new EdgeDriver(options));
			}
			else {
				driver.set(new EdgeDriver());
			}
			
			
		}
		else if(browserName==Browser.SAFARI) {
				driver.set(new SafariDriver());
			}
		else if(browserName==Browser.FIREFOX) {
			if(isHeadless) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=old");
				driver.set(new FirefoxDriver(options));
		}
			else {
				driver.set(new FirefoxDriver());
			}
			
		}
		
	}
	public void goToWebsite(String url) {
		logger.info("Navigating to the Website" + url);
		driver.get().get(url);
	
	}
	
	public void maximizeWindow() {
		logger.info("Maximizing the browser window");
		driver.get().manage().window().maximize();
	}
	
	public void clickOn(By locator) {
		logger.info("Finding Element with the locator" + locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Element found and now performing click");
		element.click();
	}
	
	public void enterText(By locator, String textToEnter) {
		logger.info("Finding Element with the locator" + locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Element found and now enter the text" + textToEnter);
		element.sendKeys(textToEnter);
	}
	
	public String getVisibleText(By locator) {
		logger.info("Finding Element with the locator" + locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Element found and now returning the visible text" + element.getText());
		return element.getText();
	}
	
	public String takeScreenShot(String name) {
	    TakesScreenshot screenshot = (TakesScreenshot) driver.get();
	    File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);

	    String projectPath = System.getProperty("user.dir");
	    String screenshotDir = projectPath + File.separator + "screenshots";

	    File dir = new File(screenshotDir);
	    if (!dir.exists()) {
	        dir.mkdirs();
	    }

	    String timeStamp = new SimpleDateFormat("HH-mm-ss").format(new Date());
	    String path = screenshotDir + File.separator + name + "-" + timeStamp + ".png";

	    try {
	        FileUtils.copyFile(screenshotData, new File(path));
	        logger.info("Screenshot saved at: " + path);
	    } catch (IOException e) {
	        logger.error("Failed to save screenshot", e);
	    }
	    return path;
	}

}
