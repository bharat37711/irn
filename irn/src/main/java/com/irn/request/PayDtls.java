package com.irn.request;

public class PayDtls {
	private String nm;
	private String accDet;
	private String mode;
	private String finInsBr;
	private String payTerm;
	private String payInstr;
	private String crTrn;
	private String dirDr;
	private Integer crDay;
	private Double paidAmt;
	private Double paymtDue;

	public String getNm() {
		return nm;
	}

	public void setNm(String nm) {
		this.nm = nm;
	}

	public String getAccDet() {
		return accDet;
	}

	public void setAccDet(String accDet) {
		this.accDet = accDet;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getFinInsBr() {
		return finInsBr;
	}

	public void setFinInsBr(String finInsBr) {
		this.finInsBr = finInsBr;
	}

	public String getPayTerm() {
		return payTerm;
	}

	public void setPayTerm(String payTerm) {
		this.payTerm = payTerm;
	}

	public String getPayInstr() {
		return payInstr;
	}

	public void setPayInstr(String payInstr) {
		this.payInstr = payInstr;
	}

	public String getCrTrn() {
		return crTrn;
	}

	public void setCrTrn(String crTrn) {
		this.crTrn = crTrn;
	}

	public String getDirDr() {
		return dirDr;
	}

	public void setDirDr(String dirDr) {
		this.dirDr = dirDr;
	}

	public Integer getCrDay() {
		return crDay;
	}

	public void setCrDay(Integer crDay) {
		this.crDay = crDay;
	}

	public Double getPaidAmt() {
		return paidAmt;
	}

	public void setPaidAmt(Double paidAmt) {
		this.paidAmt = paidAmt;
	}

	public Double getPaymtDue() {
		return paymtDue;
	}

	public void setPaymtDue(Double paymtDue) {
		this.paymtDue = paymtDue;
	}

}
