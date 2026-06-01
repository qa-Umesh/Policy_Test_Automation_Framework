package com.valuenable.utilities;

import java.util.ArrayList;
import java.util.List;

import com.valuenable.pojo.ValidationResult;

public class ValidationManager {

	private List<ValidationResult> failures = new ArrayList<>();

	public void addFailure(int rowNum, int cellNum, String fieldName, String expected, String actual) {

		failures.add(new ValidationResult(rowNum, cellNum, fieldName, expected, actual));
	}

	public boolean hasFailures() {

		return !failures.isEmpty();
	}

	public List<ValidationResult> getFailures() {

		return failures;
	}

	public void writeResults() {

		for (ValidationResult result : failures) {

			ExcelWriterUtility.markCellRed(result.getRowNum(), result.getCellNum());
		}
	}

	public void clear() {

		failures.clear();
	}
}