package com.irn.setter;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.codec.binary.Base64;

import com.irn.constrant.Constant;
import com.irn.entity.ClientInvoiceIrnInfo;
import com.irn.entity.ClientIrnCredential;
import com.irn.request.ClientCredentialRequest;
import com.irn.response.IrnGenrateData;

public class EntitySetter {

	public static ClientIrnCredential ClientCredentialRequestToEntity(ClientCredentialRequest input) {

		if (input == null)
			return null;

		ClientIrnCredential obj = new ClientIrnCredential();
		obj.setAppKey(input.getAppKey());
		obj.setPassword(Base64.encodeBase64String(input.getPassword().getBytes()));
		obj.setUserName(input.getUserName());
		obj.setForceRefreshAccessToken(input.isForceRefreshAccessToken());

		return obj;
	}

	public static ClientInvoiceIrnInfo irnGenrateDataToEntity(IrnGenrateData data) throws ParseException {

		if (data == null)
			return null;

		ClientInvoiceIrnInfo obj = new ClientInvoiceIrnInfo();

		SimpleDateFormat format = new SimpleDateFormat(Constant.DATE_FORMAT_YYY_MM_DD_HH_MM_SS);
		obj.setAckNo(data.getAckNo());
		obj.setAckDate(format.parse(data.getAckDt()));
		obj.setIrn(data.getIrn());
		obj.setSignedInvoice(data.getSignedInvoice());

		return obj;
	}

}
