package com.valuenable.pojo;

public class ValidationFailure {
	private String fieldName;

	private String expected;

	private String actual;

	private int excelColumn;

	public ValidationFailure(String fieldName, String expected, String actual, int excelColumn) {

		this.fieldName = fieldName;
		this.expected = expected;
		this.actual = actual;
		this.excelColumn = excelColumn;
	}

	public String getFieldName() {
		return fieldName;
	}

	public String getExpected() {
		return expected;
	}

	public String getActual() {
		return actual;
	}

	public int getExcelColumn() {
		return excelColumn;
	}

}
