package com.irn.setter;

import org.apache.commons.codec.binary.Base64;

import com.irn.entity.ClientInvoiceIrnInfo;
import com.irn.entity.ClientIrnCredential;
import com.irn.request.CancelInvoiceRequest;
import com.irn.request.ClientCredentialRequest;

public class RequestSetter {

	public static ClientCredentialRequest entityToClientCredentialRequest(ClientIrnCredential input) {
		if (input == null)
			return null;

		ClientCredentialRequest obj = new ClientCredentialRequest();
		obj.setAppKey(input.getAppKey());
		obj.setForceRefreshAccessToken(input.getForceRefreshAccessToken());
		obj.setUserName(input.getUserName());
		obj.setPassword(new String(Base64.decodeBase64(input.getPassword())));
		return obj;
	}

	public static CancelInvoiceRequest invocieInfoToCancelInvoiceRequest(ClientInvoiceIrnInfo info) {

		if (info == null)
			return null;

		CancelInvoiceRequest request = new CancelInvoiceRequest();
		request.setIrn(info.getIrn());
		return request;
	}
}
