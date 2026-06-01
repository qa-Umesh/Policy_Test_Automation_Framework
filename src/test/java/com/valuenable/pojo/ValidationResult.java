package com.valuenable.pojo;

import java.util.ArrayList;
import java.util.List;

import com.valuenable.constants.ExecutionStatus;

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

	private ExecutionStatus status = ExecutionStatus.PASS;

	private String reason = "";

	private List<ValidationFailure> failures = new ArrayList<>();

	public void addFailure(ValidationFailure failure) {

		failures.add(failure);

		status = ExecutionStatus.FAIL;
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

	public List<ValidationFailure> getFailures() {
		return failures;
	}

	public ExecutionStatus getStatus() {
		return status;
	}

	public void setStatus(ExecutionStatus status) {

		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {

		this.reason = reason;
	}

}
