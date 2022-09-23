package com.irn.response;

public class CancelInvoiceData {

	String Irn;
	String CancelDate;

	public CancelInvoiceData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CancelInvoiceData(String irn, String cancelDate) {
		super();
		Irn = irn;
		CancelDate = cancelDate;
	}

	public String getIrn() {
		return Irn;
	}

	public void setIrn(String irn) {
		Irn = irn;
	}

	public String getCancelDate() {
		return CancelDate;
	}

	public void setCancelDate(String cancelDate) {
		CancelDate = cancelDate;
	}

	@Override
	public String toString() {
		return "CancelInvoiceData [Irn=" + Irn + ", CancelDate=" + CancelDate + "]";
	}

}
