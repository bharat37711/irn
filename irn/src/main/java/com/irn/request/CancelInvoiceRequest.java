package com.irn.request;

public class CancelInvoiceRequest {
	private String Irn;
	private String CnlRsn;
	private String CnlRem;
	private int companyId;
	private int clientInvoiceId;

	public CancelInvoiceRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CancelInvoiceRequest(String irn, String cnlRsn, String cnlRem, int companyId, int clientInvoiceId) {
		super();
		Irn = irn;
		CnlRsn = cnlRsn;
		CnlRem = cnlRem;
		this.companyId = companyId;
		this.clientInvoiceId = clientInvoiceId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getClientInvoiceId() {
		return clientInvoiceId;
	}

	public void setClientInvoiceId(int clientInvoiceId) {
		this.clientInvoiceId = clientInvoiceId;
	}

	public String getIrn() {
		return Irn;
	}

	public void setIrn(String irn) {
		Irn = irn;
	}

	public String getCnlRsn() {
		return CnlRsn;
	}

	public void setCnlRsn(String cnlRsn) {
		CnlRsn = cnlRsn;
	}

	public String getCnlRem() {
		return CnlRem;
	}

	public void setCnlRem(String cnlRem) {
		CnlRem = cnlRem;
	}

	@Override
	public String toString() {
		return "CancelInvoiceRequest [Irn=" + Irn + ", CnlRsn=" + CnlRsn + ", CnlRem=" + CnlRem + ", companyId="
				+ companyId + ", clientInvoiceId=" + clientInvoiceId + "]";
	}

}
