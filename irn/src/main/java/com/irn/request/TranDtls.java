package com.irn.request;

public class TranDtls {

	private String taxSch;
	private String supTyp;
	private String regRev;
	private String ecmGstin;
	private String igstOnIntra;

	public TranDtls() {
		super();
	}

	public TranDtls(String taxSch, String supTyp, String regRev, String ecmGstin, String igstOnIntra) {
		super();
		this.taxSch = taxSch;
		this.supTyp = supTyp;
		this.regRev = regRev;
		this.ecmGstin = ecmGstin;
		this.igstOnIntra = igstOnIntra;
	}

	public String getTaxSch() {
		return taxSch;
	}

	public void setTaxSch(String taxSch) {
		this.taxSch = taxSch;
	}

	public String getSupTyp() {
		return supTyp;
	}

	public void setSupTyp(String supTyp) {
		this.supTyp = supTyp;
	}

	public String getRegRev() {
		return regRev;
	}

	public void setRegRev(String regRev) {
		this.regRev = regRev;
	}

	public String getEcmGstin() {
		return ecmGstin;
	}

	public void setEcmGstin(String ecmGstin) {
		this.ecmGstin = ecmGstin;
	}

	public String getIgstOnIntra() {
		return igstOnIntra;
	}

	public void setIgstOnIntra(String igstOnIntra) {
		this.igstOnIntra = igstOnIntra;
	}

	@Override
	public String toString() {
		return "TranDtls [taxSch=" + taxSch + ", supTyp=" + supTyp + ", regRev=" + regRev + ", ecmGstin=" + ecmGstin
				+ ", igstOnIntra=" + igstOnIntra + "]";
	}

}
