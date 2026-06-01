package com.valuenable.utilities;

public class ValidationResult {
	  private int rowNum;
	    private int cellNum;
	    private String fieldName;
	    private String expected;
	    private String actual;

	    public ValidationResult(
	            int rowNum,
	            int cellNum,
	            String fieldName,
	            String expected,
	            String actual) {

	        this.rowNum = rowNum;
	        this.cellNum = cellNum;
	        this.fieldName = fieldName;
	        this.expected = expected;
	        this.actual = actual;
	    }
	    public int getRowNum() {
	        return rowNum;
	    }

	    public int getCellNum() {
	        return cellNum;
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

}
