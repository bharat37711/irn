package com.irn.response;

public class IrnGenrateData {

	private String AckNo;
	private String AckDt;
	private String Irn;
	private String SignedInvoice;
	private String Status;
	private String ACT;
	private String EwbNo;
	private String EwbDt;
	private String EwbValidTill;
	private String Remarks;

	public String getAckNo() {
		return AckNo;
	}

	public void setAckNo(String ackNo) {
		AckNo = ackNo;
	}

	public String getAckDt() {
		return AckDt;
	}

	public void setAckDt(String ackDt) {
		AckDt = ackDt;
	}

	public String getIrn() {
		return Irn;
	}

	public void setIrn(String irn) {
		Irn = irn;
	}

	public String getSignedInvoice() {
		return SignedInvoice;
	}

	public void setSignedInvoice(String signedInvoice) {
		SignedInvoice = signedInvoice;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getACT() {
		return ACT;
	}

	public void setACT(String aCT) {
		ACT = aCT;
	}

	public String getEwbNo() {
		return EwbNo;
	}

	public void setEwbNo(String ewbNo) {
		EwbNo = ewbNo;
	}

	public String getEwbDt() {
		return EwbDt;
	}

	public void setEwbDt(String ewbDt) {
		EwbDt = ewbDt;
	}

	public String getEwbValidTill() {
		return EwbValidTill;
	}

	public void setEwbValidTill(String ewbValidTill) {
		EwbValidTill = ewbValidTill;
	}

	public String getRemarks() {
		return Remarks;
	}

	public void setRemarks(String remarks) {
		Remarks = remarks;
	}

	@Override
	public String toString() {
		return "IrnGenrateData [AckNo=" + AckNo + ", AckDt=" + AckDt + ", Irn=" + Irn + ", SignedInvoice="
				+ SignedInvoice + ", Status=" + Status + ", ACT=" + ACT + ", EwbNo=" + EwbNo + ", EwbDt=" + EwbDt
				+ ", EwbValidTill=" + EwbValidTill + ", Remarks=" + Remarks + "]";
	}

}
