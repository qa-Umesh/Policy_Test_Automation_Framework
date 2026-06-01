package com.valuenable.pojo;

public class PolicyPerformanceData {

	// BASIC DETAILS

	private String policyNo;

	private String premiumPaid;
	private String foundValue;
	private String returns;
	private String charges;
	private String difference;
	private int excelRowNum;
	private String executionStatus;
	private String executionRemarks;

	public String getExecutionStatus() {
	    return executionStatus;
	}

	public void setExecutionStatus(String executionStatus) {
	    this.executionStatus = executionStatus;
	}

	public String getExecutionRemarks() {
	    return executionRemarks;
	}

	public void setExecutionRemarks(String executionRemarks) {
	    this.executionRemarks = executionRemarks;
	}

	// =========================
	// PAY 1 AND STAY
	// =========================

	public int getExcelRowNum() {
		return excelRowNum;
	}

	public void setExcelRowNum(int excelRowNum) {
		this.excelRowNum = excelRowNum;
	}

	private String p1_T1_8;
	private String p1_T1_4;
	private String p1_T1_Historical_rate;

	private String p1_T2_R1_8;
	private String p1_T2_R1_4;
	private String p1_T2_R1_Historical_Growth;

	private String p1_T2_R2_8;
	private String p1_T2_R2_4;
	private String p1_T2_R2_Historical_Growth;

	private String p1_T2_R3_8;
	private String p1_T2_R3_4;
	private String p1_T2_R3_Historical_Growth;

	// =========================
	// PAY 3 AND STAY
	// =========================

	private String p3_T1_8;
	private String p3_T1_4;
	private String p3_T1_Historical_rat;

	private String p3_T2_R1_8;
	private String p3_T2_R1_4;
	private String p3_T2_R1_Historical_Growth;

	private String p3_T2_R2_8;
	private String p3_T2_R2_4;
	private String p3_T2_R2_Historical_Growth;

	private String p3_T2_R3_8;
	private String p3_T2_R3_4;
	private String p3_T2_R3_Historical_Growth;

	// =========================
	// DON'T PAY JUST STAY
	// =========================

	private String p0_T1_8;
	private String p0_T1_4;
	private String p0_T1_Historical_rat;

	private String p0_T2_R1_8;
	private String p0_T2_R1_4;
	private String p0_T2_R1_Historical_Growth;

	private String p0_T2_R2_8;
	private String p0_T2_R2_4;
	private String p0_T2_R2_Historical_Growth;

	private String p0_T2_R3_8;
	private String p0_T2_R3_4;
	private String p0_T2_R3_Historical_Growth;

	// =========================
	// PAY AS PER ORIGINAL
	// =========================

	private String payOriginal_T1_8;
	private String payOriginal_T1_4;
	private String payOriginal_T1_Historical_rat;

	private String payOriginal_T2_R1_8;
	private String payOriginal_T2_R1_4;
	private String payOriginal_T2_R1_Historical_Growth;

	private String payOriginal_T2_R2_8;
	private String payOriginal_T2_R2_4;
	private String payOriginal_T2_R2_Historical_Growth;

	private String payOriginal_T2_R3_8;
	private String payOriginal_T2_R3_4;
	private String payOriginal_T2_R3_Historical_Growth;

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getPremiumPaid() {
		return premiumPaid;
	}

	public void setPremiumPaid(String premiumPaid) {
		this.premiumPaid = premiumPaid;
	}

	public String getFoundValue() {
		return foundValue;
	}

	public void setFoundValue(String foundValue) {
		this.foundValue = foundValue;
	}

	public String getReturns() {
		return returns;
	}

	public void setReturns(String returns) {
		this.returns = returns;
	}

	public String getCharges() {
		return charges;
	}

	public void setCharges(String charges) {
		this.charges = charges;
	}

	public String getDifference() {
		return difference;
	}

	public void setDifference(String difference) {
		this.difference = difference;
	}

	public String getP1_T1_8() {
		return p1_T1_8;
	}

	public void setP1_T1_8(String p1_T1_8) {
		this.p1_T1_8 = p1_T1_8;
	}

	public String getP1_T1_4() {
		return p1_T1_4;
	}

	public void setP1_T1_4(String p1_T1_4) {
		this.p1_T1_4 = p1_T1_4;
	}

	public String getP1_T1_Historical_rate() {
		return p1_T1_Historical_rate;
	}

	public void setP1_T1_Historical_rate(String p1_T1_Historical_rate) {
		this.p1_T1_Historical_rate = p1_T1_Historical_rate;
	}

	public String getP1_T2_R1_8() {
		return p1_T2_R1_8;
	}

	public void setP1_T2_R1_8(String p1_T2_R1_8) {
		this.p1_T2_R1_8 = p1_T2_R1_8;
	}

	public String getP1_T2_R1_4() {
		return p1_T2_R1_4;
	}

	public void setP1_T2_R1_4(String p1_T2_R1_4) {
		this.p1_T2_R1_4 = p1_T2_R1_4;
	}

	public String getP1_T2_R1_Historical_Growth() {
		return p1_T2_R1_Historical_Growth;
	}

	public void setP1_T2_R1_Historical_Growth(String p1_T2_R1_Historical_Growth) {
		this.p1_T2_R1_Historical_Growth = p1_T2_R1_Historical_Growth;
	}

	public String getP1_T2_R2_8() {
		return p1_T2_R2_8;
	}

	public void setP1_T2_R2_8(String p1_T2_R2_8) {
		this.p1_T2_R2_8 = p1_T2_R2_8;
	}

	public String getP1_T2_R2_4() {
		return p1_T2_R2_4;
	}

	public void setP1_T2_R2_4(String p1_T2_R2_4) {
		this.p1_T2_R2_4 = p1_T2_R2_4;
	}

	public String getP1_T2_R2_Historical_Growth() {
		return p1_T2_R2_Historical_Growth;
	}

	public void setP1_T2_R2_Historical_Growth(String p1_T2_R2_Historical_Growth) {
		this.p1_T2_R2_Historical_Growth = p1_T2_R2_Historical_Growth;
	}

	public String getP1_T2_R3_8() {
		return p1_T2_R3_8;
	}

	public void setP1_T2_R3_8(String p1_T2_R3_8) {
		this.p1_T2_R3_8 = p1_T2_R3_8;
	}

	public String getP1_T2_R3_4() {
		return p1_T2_R3_4;
	}

	public void setP1_T2_R3_4(String p1_T2_R3_4) {
		this.p1_T2_R3_4 = p1_T2_R3_4;
	}

	public String getP1_T2_R3_Historical_Growth() {
		return p1_T2_R3_Historical_Growth;
	}

	public void setP1_T2_R3_Historical_Growth(String p1_T2_R3_Historical_Growth) {
		this.p1_T2_R3_Historical_Growth = p1_T2_R3_Historical_Growth;
	}

	public String getP3_T1_8() {
		return p3_T1_8;
	}

	public void setP3_T1_8(String p3_T1_8) {
		this.p3_T1_8 = p3_T1_8;
	}

	public String getP3_T1_4() {
		return p3_T1_4;
	}

	public void setP3_T1_4(String p3_T1_4) {
		this.p3_T1_4 = p3_T1_4;
	}

	public String getP3_T1_Historical_rat() {
		return p3_T1_Historical_rat;
	}

	public void setP3_T1_Historical_rat(String p3_T1_Historical_rat) {
		this.p3_T1_Historical_rat = p3_T1_Historical_rat;
	}

	public String getP3_T2_R1_8() {
		return p3_T2_R1_8;
	}

	public void setP3_T2_R1_8(String p3_T2_R1_8) {
		this.p3_T2_R1_8 = p3_T2_R1_8;
	}

	public String getP3_T2_R1_4() {
		return p3_T2_R1_4;
	}

	public void setP3_T2_R1_4(String p3_T2_R1_4) {
		this.p3_T2_R1_4 = p3_T2_R1_4;
	}

	public String getP3_T2_R1_Historical_Growth() {
		return p3_T2_R1_Historical_Growth;
	}

	public void setP3_T2_R1_Historical_Growth(String p3_T2_R1_Historical_Growth) {
		this.p3_T2_R1_Historical_Growth = p3_T2_R1_Historical_Growth;
	}

	public String getP3_T2_R2_8() {
		return p3_T2_R2_8;
	}

	public void setP3_T2_R2_8(String p3_T2_R2_8) {
		this.p3_T2_R2_8 = p3_T2_R2_8;
	}

	public String getP3_T2_R2_4() {
		return p3_T2_R2_4;
	}

	public void setP3_T2_R2_4(String p3_T2_R2_4) {
		this.p3_T2_R2_4 = p3_T2_R2_4;
	}

	public String getP3_T2_R2_Historical_Growth() {
		return p3_T2_R2_Historical_Growth;
	}

	public void setP3_T2_R2_Historical_Growth(String p3_T2_R2_Historical_Growth) {
		this.p3_T2_R2_Historical_Growth = p3_T2_R2_Historical_Growth;
	}

	public String getP3_T2_R3_8() {
		return p3_T2_R3_8;
	}

	public void setP3_T2_R3_8(String p3_T2_R3_8) {
		this.p3_T2_R3_8 = p3_T2_R3_8;
	}

	public String getP3_T2_R3_4() {
		return p3_T2_R3_4;
	}

	public void setP3_T2_R3_4(String p3_T2_R3_4) {
		this.p3_T2_R3_4 = p3_T2_R3_4;
	}

	public String getP3_T2_R3_Historical_Growth() {
		return p3_T2_R3_Historical_Growth;
	}

	public void setP3_T2_R3_Historical_Growth(String p3_T2_R3_Historical_Growth) {
		this.p3_T2_R3_Historical_Growth = p3_T2_R3_Historical_Growth;
	}

	public String getP0_T1_8() {
		return p0_T1_8;
	}

	public void setP0_T1_8(String p0_T1_8) {
		this.p0_T1_8 = p0_T1_8;
	}

	public String getP0_T1_4() {
		return p0_T1_4;
	}

	public void setP0_T1_4(String p0_T1_4) {
		this.p0_T1_4 = p0_T1_4;
	}

	public String getP0_T1_Historical_rat() {
		return p0_T1_Historical_rat;
	}

	public void setP0_T1_Historical_rat(String p0_T1_Historical_rat) {
		this.p0_T1_Historical_rat = p0_T1_Historical_rat;
	}

	public String getP0_T2_R1_8() {
		return p0_T2_R1_8;
	}

	public void setP0_T2_R1_8(String p0_T2_R1_8) {
		this.p0_T2_R1_8 = p0_T2_R1_8;
	}

	public String getP0_T2_R1_4() {
		return p0_T2_R1_4;
	}

	public void setP0_T2_R1_4(String p0_T2_R1_4) {
		this.p0_T2_R1_4 = p0_T2_R1_4;
	}

	public String getP0_T2_R1_Historical_Growth() {
		return p0_T2_R1_Historical_Growth;
	}

	public void setP0_T2_R1_Historical_Growth(String p0_T2_R1_Historical_Growth) {
		this.p0_T2_R1_Historical_Growth = p0_T2_R1_Historical_Growth;
	}

	public String getP0_T2_R2_8() {
		return p0_T2_R2_8;
	}

	public void setP0_T2_R2_8(String p0_T2_R2_8) {
		this.p0_T2_R2_8 = p0_T2_R2_8;
	}

	public String getP0_T2_R2_4() {
		return p0_T2_R2_4;
	}

	public void setP0_T2_R2_4(String p0_T2_R2_4) {
		this.p0_T2_R2_4 = p0_T2_R2_4;
	}

	public String getP0_T2_R2_Historical_Growth() {
		return p0_T2_R2_Historical_Growth;
	}

	public void setP0_T2_R2_Historical_Growth(String p0_T2_R2_Historical_Growth) {
		this.p0_T2_R2_Historical_Growth = p0_T2_R2_Historical_Growth;
	}

	public String getP0_T2_R3_8() {
		return p0_T2_R3_8;
	}

	public void setP0_T2_R3_8(String p0_T2_R3_8) {
		this.p0_T2_R3_8 = p0_T2_R3_8;
	}

	public String getP0_T2_R3_4() {
		return p0_T2_R3_4;
	}

	public void setP0_T2_R3_4(String p0_T2_R3_4) {
		this.p0_T2_R3_4 = p0_T2_R3_4;
	}

	public String getP0_T2_R3_Historical_Growth() {
		return p0_T2_R3_Historical_Growth;
	}

	public void setP0_T2_R3_Historical_Growth(String p0_T2_R3_Historical_Growth) {
		this.p0_T2_R3_Historical_Growth = p0_T2_R3_Historical_Growth;
	}

	public String getPayOriginal_T1_8() {
		return payOriginal_T1_8;
	}

	public void setPayOriginal_T1_8(String payOriginal_T1_8) {
		this.payOriginal_T1_8 = payOriginal_T1_8;
	}

	public String getPayOriginal_T1_4() {
		return payOriginal_T1_4;
	}

	public void setPayOriginal_T1_4(String payOriginal_T1_4) {
		this.payOriginal_T1_4 = payOriginal_T1_4;
	}

	public String getPayOriginal_T1_Historical_rat() {
		return payOriginal_T1_Historical_rat;
	}

	public void setPayOriginal_T1_Historical_rat(String payOriginal_T1_Historical_rat) {
		this.payOriginal_T1_Historical_rat = payOriginal_T1_Historical_rat;
	}

	public String getPayOriginal_T2_R1_8() {
		return payOriginal_T2_R1_8;
	}

	public void setPayOriginal_T2_R1_8(String payOriginal_T2_R1_8) {
		this.payOriginal_T2_R1_8 = payOriginal_T2_R1_8;
	}

	public String getPayOriginal_T2_R1_4() {
		return payOriginal_T2_R1_4;
	}

	public void setPayOriginal_T2_R1_4(String payOriginal_T2_R1_4) {
		this.payOriginal_T2_R1_4 = payOriginal_T2_R1_4;
	}

	public String getPayOriginal_T2_R1_Historical_Growth() {
		return payOriginal_T2_R1_Historical_Growth;
	}

	public void setPayOriginal_T2_R1_Historical_Growth(String payOriginal_T2_R1_Historical_Growth) {
		this.payOriginal_T2_R1_Historical_Growth = payOriginal_T2_R1_Historical_Growth;
	}

	public String getPayOriginal_T2_R2_8() {
		return payOriginal_T2_R2_8;
	}

	public void setPayOriginal_T2_R2_8(String payOriginal_T2_R2_8) {
		this.payOriginal_T2_R2_8 = payOriginal_T2_R2_8;
	}

	public String getPayOriginal_T2_R2_4() {
		return payOriginal_T2_R2_4;
	}

	public void setPayOriginal_T2_R2_4(String payOriginal_T2_R2_4) {
		this.payOriginal_T2_R2_4 = payOriginal_T2_R2_4;
	}

	public String getPayOriginal_T2_R2_Historical_Growth() {
		return payOriginal_T2_R2_Historical_Growth;
	}

	public void setPayOriginal_T2_R2_Historical_Growth(String payOriginal_T2_R2_Historical_Growth) {
		this.payOriginal_T2_R2_Historical_Growth = payOriginal_T2_R2_Historical_Growth;
	}

	public String getPayOriginal_T2_R3_8() {
		return payOriginal_T2_R3_8;
	}

	public void setPayOriginal_T2_R3_8(String payOriginal_T2_R3_8) {
		this.payOriginal_T2_R3_8 = payOriginal_T2_R3_8;
	}

	public String getPayOriginal_T2_R3_4() {
		return payOriginal_T2_R3_4;
	}

	public void setPayOriginal_T2_R3_4(String payOriginal_T2_R3_4) {
		this.payOriginal_T2_R3_4 = payOriginal_T2_R3_4;
	}

	public String getPayOriginal_T2_R3_Historical_Growth() {
		return payOriginal_T2_R3_Historical_Growth;
	}

	public void setPayOriginal_T2_R3_Historical_Growth(String payOriginal_T2_R3_Historical_Growth) {
		this.payOriginal_T2_R3_Historical_Growth = payOriginal_T2_R3_Historical_Growth;
	}

	// =========================================================
	// GETTERS AND SETTERS
	// =========================================================

}
