package com.irn.request;

import java.util.ArrayList;

public class RefDtls {
	private String invRm;
	private DocPerdDtls docPerdDtls;
	private ArrayList<PrecDocDtls> precDocDtls;
	private ArrayList<ContrDtls> contrDtls;

	public String getInvRm() {
		return invRm;
	}

	public void setInvRm(String invRm) {
		this.invRm = invRm;
	}

	public DocPerdDtls getDocPerdDtls() {
		return docPerdDtls;
	}

	public void setDocPerdDtls(DocPerdDtls docPerdDtls) {
		this.docPerdDtls = docPerdDtls;
	}

	public ArrayList<PrecDocDtls> getPrecDocDtls() {
		return precDocDtls;
	}

	public void setPrecDocDtls(ArrayList<PrecDocDtls> precDocDtls) {
		this.precDocDtls = precDocDtls;
	}

	public ArrayList<ContrDtls> getContrDtls() {
		return contrDtls;
	}

	public void setContrDtls(ArrayList<ContrDtls> contrDtls) {
		this.contrDtls = contrDtls;
	}

}
