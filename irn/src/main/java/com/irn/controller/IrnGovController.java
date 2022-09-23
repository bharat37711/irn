package com.irn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.irn.request.CancelInvoiceRequest;
import com.irn.request.IrnGenrateRequest;
import com.irn.response.CustomResponse;
import com.irn.services.IrnGovService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/v2")
public class IrnGovController {

	@Autowired
	private IrnGovService irnGovService;

	@ApiOperation(value = "to genrate invoice")
	@RequestMapping(path = "/genrateInvocie/{companyId}", method = RequestMethod.POST)
	public ResponseEntity<?> genrateInvocie(@PathVariable Integer companyId,
			@RequestBody(required = true) IrnGenrateRequest irnGenrate) {

		CustomResponse customResponse = irnGovService.irnGenrateURL(companyId, irnGenrate);

		return new ResponseEntity<>(customResponse, HttpStatus.ACCEPTED);
	}

	@ApiOperation(value = "to cancel invoice")
	@RequestMapping(path = "/cancelInvoice", method = RequestMethod.POST)
	public ResponseEntity<?> cancelInvoice(@RequestBody(required = true) CancelInvoiceRequest cancelInvoiceRequest) {

		CustomResponse customResponse = irnGovService.cancelIrnWithClientInvoiceId(cancelInvoiceRequest);
		return new ResponseEntity<>(customResponse, HttpStatus.ACCEPTED);
	}
}
