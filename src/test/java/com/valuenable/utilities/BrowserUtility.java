package com.valuenable.utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.valuenable.constants.Browser;

public class BrowserUtility {

	private static ThreadLocal<WebDriver> localDriver = new ThreadLocal<WebDriver>();
	protected WebDriverWait wait;

	public BrowserUtility(Browser browser, boolean isHeadless) {

		if (isHeadless) {
			if (browser == Browser.CHROME) {

				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=old");
				options.addArguments("--start-maximized");

				localDriver.set(new ChromeDriver(options));

			} else if (browser == Browser.FIREFOX) {

				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=old");
				options.addArguments("--start-maximized");

				localDriver.set( new FirefoxDriver(options));
			}

			wait = new WebDriverWait(localDriver.get(), Duration.ofSeconds(20));

		} else {
			if (browser == Browser.CHROME) {

				ChromeOptions options = new ChromeOptions();
				options.addArguments("--start-maximized");

				localDriver.set(new ChromeDriver(options));

			} else if (browser == Browser.FIREFOX) {

				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--start-maximized");

				localDriver.set( new FirefoxDriver(options));
			}

			wait = new WebDriverWait(localDriver.get(), Duration.ofSeconds(20));
		}
	}

	public BrowserUtility(WebDriver driver) {
		localDriver.set(driver);
	
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	public WebDriver getDriver() {
		return localDriver.get();
	}

	public void getURL(String url) {
		localDriver.get().get(url);
	}

	public void enterText(By locator, String textToEnter) {

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		element.clear();
		element.sendKeys(textToEnter);
	}

	public void specialKey(By locator, Keys key) {

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		element.sendKeys(key);
	}

	public void clickOn(By locator) {

		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

		element.click();
	}

	public void scrollIntoView(By locator) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public WebElement getWebElement(By locator) {

		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public List<WebElement> getAllWebElements(By locator) {

		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	public void waitForElement(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public String normalizeValue(String value) {

		if (value == null) {
			return "";
		}

		return value.replace("₹", "").replace(",", "").replace("%", "").trim();
	}

	public List<WebElement> getVisibleElements(By locator) {
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	public void selectOptionFromDropDown(By locator, String visibleText) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}

	public void quiteBrowser() {

	    WebDriver driver = localDriver.get();

	    if(driver != null) {

	        driver.quit();

	        localDriver.remove();
	    }
	}

}