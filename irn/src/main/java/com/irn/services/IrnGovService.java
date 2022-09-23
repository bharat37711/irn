package com.irn.services;

import com.irn.entity.ClientIrnCredential;
import com.irn.request.CancelInvoiceRequest;
import com.irn.request.IrnGenrateRequest;
import com.irn.response.CustomResponse;

public interface IrnGovService {
	public CustomResponse irnAuthURL(ClientIrnCredential credential) throws Exception;

	public CustomResponse irnGenrateURL(Integer companyId, IrnGenrateRequest irnGenrate);

	public CustomResponse cancelIrnWithClientInvoiceId(CancelInvoiceRequest cancelInvoiceRequest);

}
