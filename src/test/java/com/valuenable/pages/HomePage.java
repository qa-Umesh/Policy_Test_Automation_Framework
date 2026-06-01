package com.valuenable.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.valuenable.utilities.BrowserUtility;
import com.valuenable.utilities.ValidationManager;

public class HomePage extends BrowserUtility {
	private ValidationManager validationManager;

	public HomePage(WebDriver driver, ValidationManager validationManager) {
		super(driver);
		this.validationManager = validationManager;
	}

	private static final By NO_DATA_FOUND_LOCATOR = By.xpath("//*[contains(text(),'No Policies Found')]");
	private static final By POLICY_DD_LOCATOR = By
			.xpath("//li[contains(@class,'nav-item')]//a[contains(text(),'Policies')]");

	private static final By ALL_POLICY_OPTION = By.xpath("//a[contains(text(),'All Policies')]");

	private static final By SEARCH_ICON_LOCATOR = By.xpath("//input[@class='ap-search-input']");

	private static final By PERFORMANCE_SNAPSHOT_LINK_LOCATOR = By
			.xpath("//a[contains(text(),'Performance Snapshot')]");

	// PERFORMANCE TABLE
	private static final By POLICY_PERFORMANCE_ROWS = By
			.xpath("//table[contains(@class,'policy-snapshot-table')]//tbody//tr");

	// FUTURE PERFORMANCE TAB
	private static final By FUTURE_PERFORMANCE_LOCATOR = By.xpath("//button[contains(text(),'Future Performance')]");

	private static final By OTHOR_SCENARIO_OPTION_LOCATOR = By.xpath("//button[contains(text(),'Other Scenarios')]");

	private static final By PAY_AS_PER_CONVENIENCE_LOCATOR = By.xpath("//p[contains(text(),'Pay as per Convenience')]");

	private static final By PAY_AS_PER_CONVEIENCE_TABLE_FIRST_LOCATOR = By
			.xpath("(//table[contains(@class,'scenarios-table')])[1]//tbody//tr[last()]");

	private static final By PAY_OPTION_SELECT_DROP_DOWN_LOCATOR = By.id("payOption");

	private static final By SECOND_TABLE_ROWS = By.xpath("(//table[contains(@class,'scenarios-table')])[2]//tbody//tr");

	private static final By CLOSE_PAY_AS_CON = By.xpath("//img[@src='./assets/images/scnerios-arrow.png']");

	private static final By PAY_AS_PER_CONVENIENCE = By.xpath("//p[contains(text(),'Pay as per original')]");

	// ===========================
	// NAVIGATION METHODS
	// ===========================

	public HomePage navigateToAllPolicy() {

		clickOn(POLICY_DD_LOCATOR);
		clickOn(ALL_POLICY_OPTION);

		return this;
	}
	
	public HomePage navigateToPerformanceTillDate() {

		clickOn(PERFORMANCE_SNAPSHOT_LINK_LOCATOR);

		return new HomePage(getDriver(), validationManager);
	}

	public boolean isPolicyFound() {

		try {

			List<WebElement> elements = getDriver().findElements(NO_DATA_FOUND_LOCATOR);

			return elements.isEmpty();

		} catch (Exception e) {

			return true;
		}
	}

	public void markPolicyNotFound(int rowNum, String policyNo) {

		validationManager.addFailure(rowNum, 0, "Policy Search", policyNo, "POLICY NOT FOUND");
	}

	public boolean searchPolicyBy(String policyNo) {

		enterText(SEARCH_ICON_LOCATOR, policyNo);

		specialKey(SEARCH_ICON_LOCATOR, Keys.ENTER);

		hardWait(1000);

		if (!isPolicyFound()) {

			return false;
		}

		clickOn(PERFORMANCE_SNAPSHOT_LINK_LOCATOR);

		hardWait(700);

		return true;
	}

	public HomePage navigateToPayConveneienceTab() {

		clickOn(FUTURE_PERFORMANCE_LOCATOR);

		hardWait(500);

		scrollIntoView(OTHOR_SCENARIO_OPTION_LOCATOR);

		clickOn(OTHOR_SCENARIO_OPTION_LOCATOR);

		hardWait(500);

		clickOn(PAY_AS_PER_CONVENIENCE_LOCATOR);

		hardWait(700);

		return this;
	}

	public HomePage navigateToPayAsPerConvenience() {

		clickOn(PAY_AS_PER_CONVENIENCE);

		hardWait(700);

		return this;
	}

	public HomePage closePayConveience() {

		clickOn(CLOSE_PAY_AS_CON);

		hardWait(500);

		return this;
	}

	public HomePage selectPayOption(String option) {

		WebElement oldTable = getWebElement(PAY_AS_PER_CONVEIENCE_TABLE_FIRST_LOCATOR);

		selectOptionFromDropDown(PAY_OPTION_SELECT_DROP_DOWN_LOCATOR, option);

		try {

			waitForStaleElement(oldTable);

		} catch (Exception e) {

			hardWait(700);
		}

		return this;
	}

	// ===========================
	// VALIDATION METHODS
	// ===========================

	public HomePage validatePolicyPerformanceTable(int excelRowNum, String expectedPremiumPaid,
			String expectedFundValue, String expectedReturns, String expectedCharges) {

		hardWait(300);

		List<WebElement> rows = getAllWebElements(POLICY_PERFORMANCE_ROWS);

		List<String> actualValues = new ArrayList<>();

		for (WebElement row : rows) {

			List<WebElement> columns = row.findElements(By.tagName("td"));

			if (columns.size() > 1) {

				actualValues.add(normalize(columns.get(1).getText()));
			}
		}

		validate("Premium Paid", expectedPremiumPaid, getValue(actualValues, 0), excelRowNum, 1);

		validate("Fund Value", expectedFundValue, getValue(actualValues, 1), excelRowNum, 2);

		validate("Returns", expectedReturns, getValue(actualValues, 2), excelRowNum, 3);

		validate("Charges", expectedCharges, getValue(actualValues, 3), excelRowNum, 4);

		return this;
	}

	public HomePage validate_FirstTable(int excelRowNum, int startColumn, String expected8Percent,
			String expected4Percent, String expectedHistoricalRate) {

		wait.until(driver -> {

			WebElement row = driver.findElement(PAY_AS_PER_CONVEIENCE_TABLE_FIRST_LOCATOR);

			List<WebElement> cols = row.findElements(By.xpath("./td[position()>1]"));

			return cols.size() >= 4 && !cols.get(1).getText().trim().isEmpty();
		});

		WebElement lastRow = getWebElement(PAY_AS_PER_CONVEIENCE_TABLE_FIRST_LOCATOR);

		List<WebElement> columns = lastRow.findElements(By.xpath("./td[position()>1]"));

		// Skip Total Investment (index 0)

		String actual8Percent = normalize(columns.get(1).getText());

		String actual4Percent = normalize(columns.get(2).getText());

		String actualHistoricalRate = normalize(columns.get(3).getText());

		validate("8 Percent Return", expected8Percent, actual8Percent, excelRowNum, startColumn);

		validate("4 Percent Return", expected4Percent, actual4Percent, excelRowNum, startColumn + 1);

		validate("Historical Rate", expectedHistoricalRate, actualHistoricalRate, excelRowNum, startColumn + 2);

		return this;
	}

	public HomePage validateSecondTableValues(
	        int excelRowNum,
	        int startColumn,

	        String expected1,
	        String expected2,
	        String expected3,

	        String expected4,
	        String expected5,
	        String expected6,

	        String expected7,
	        String expected8,
	        String expected9) {

	    hardWait(300);

	    List<WebElement> rows =
	            getAllWebElements(SECOND_TABLE_ROWS);

	    List<WebElement> firstRowColumns =
	            rows.get(0).findElements(By.tagName("td"));

	    boolean historicalPresent =
	            firstRowColumns.size() >= 4;

	    if (historicalPresent) {

	        // ==========================
	        // NORMAL FLOW
	        // ==========================

	        List<String> actualValues =
	                new ArrayList<>();

	        for (WebElement row : rows) {

	            List<WebElement> columns =
	                    row.findElements(By.tagName("td"));

	            actualValues.add(
	                    normalize(columns.get(1).getText()));

	            actualValues.add(
	                    normalize(columns.get(2).getText()));

	            actualValues.add(
	                    normalize(columns.get(3).getText()));
	        }

	        validate("Value 1", expected1, actualValues.get(0), excelRowNum, startColumn);
	        validate("Value 2", expected2, actualValues.get(1), excelRowNum, startColumn + 1);
	        validate("Value 3", expected3, actualValues.get(2), excelRowNum, startColumn + 2);

	        validate("Value 4", expected4, actualValues.get(3), excelRowNum, startColumn + 3);
	        validate("Value 5", expected5, actualValues.get(4), excelRowNum, startColumn + 4);
	        validate("Value 6", expected6, actualValues.get(5), excelRowNum, startColumn + 5);

	        validate("Value 7", expected7, actualValues.get(6), excelRowNum, startColumn + 6);
	        validate("Value 8", expected8, actualValues.get(7), excelRowNum, startColumn + 7);
	        validate("Value 9", expected9, actualValues.get(8), excelRowNum, startColumn + 8);

	    } else {

	        // ==========================
	        // HISTORICAL COLUMN NOT PRESENT
	        // ==========================

	        validate("Value 1",
	                expected1,
	                normalize(rows.get(0).findElements(By.tagName("td")).get(1).getText()),
	                excelRowNum,
	                startColumn);

	        validate("Value 2",
	                expected2,
	                normalize(rows.get(0).findElements(By.tagName("td")).get(2).getText()),
	                excelRowNum,
	                startColumn + 1);

	        validate("Value 4",
	                expected4,
	                normalize(rows.get(1).findElements(By.tagName("td")).get(1).getText()),
	                excelRowNum,
	                startColumn + 3);

	        validate("Value 5",
	                expected5,
	                normalize(rows.get(1).findElements(By.tagName("td")).get(2).getText()),
	                excelRowNum,
	                startColumn + 4);

	        validate("Value 7",
	                expected7,
	                normalize(rows.get(2).findElements(By.tagName("td")).get(1).getText()),
	                excelRowNum,
	                startColumn + 6);

	        validate("Value 8",
	                expected8,
	                normalize(rows.get(2).findElements(By.tagName("td")).get(2).getText()),
	                excelRowNum,
	                startColumn + 7);

	        System.out.println(
	                "Historical column not available for this policy. Historical validations skipped.");
	    }

	    return this;
	}
	// ===========================
	// COMMON METHODS
	// ===========================

	public String normalize(String value) {

		if (value == null) {
			return "";
		}

		value = value.replace("₹", "").replace(",", "").replace("%", "").trim();

		try {

			double number = Double.parseDouble(value);

			if (number == (long) number) {

				return String.valueOf((long) number);
			}

			return String.format("%.2f", number);

		} catch (Exception e) {

			return value;
		}
	}

	private boolean compareValues(String expected, String actual) {

		try {

			double exp = Double.parseDouble(expected);
			double act = Double.parseDouble(actual);

			// Handle percentage values
			if (exp < 1 && act > 1) {

				exp = exp * 100;
			}

			// Allow small rounding differences
			double diff = Math.abs(exp - act);

			return diff <= 1;

		} catch (Exception e) {

			return expected.equals(actual);
		}
	}

	private void validate(String fieldName, String expected, String actual, int rowNum, int cellNum) {

		expected = normalize(expected);
		actual = normalize(actual);

		if (!compareValues(expected, actual)) {

			System.out.println("FAILED : " + fieldName + " | Expected : " + expected + " | Actual : " + actual);

			validationManager.addFailure(rowNum, cellNum, fieldName, expected, actual);
		}
	}

	private String getValue(List<String> values, int index) {

		try {

			return values.get(index);

		} catch (Exception e) {

			return "";
		}
	}

	public void hardWait(long milliseconds) {

		try {

			Thread.sleep(milliseconds);

		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public void waitForStaleElement(WebElement element) {

		int retry = 0;

		while (retry < 10) {

			try {

				element.isDisplayed();

				hardWait(100);

				retry++;

			} catch (StaleElementReferenceException e) {

				break;
			}
		}
	}

	
}