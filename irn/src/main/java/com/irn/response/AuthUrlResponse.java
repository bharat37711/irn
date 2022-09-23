package com.irn.response;

import com.google.gson.annotations.SerializedName;

public class AuthUrlResponse {

	Integer Status;
	Object ErrorDetails;
	@SerializedName("Data")
	AuthUrlData data;
	Object InfoDtls;

	public AuthUrlResponse() {
		super();
	}

	public AuthUrlResponse(Integer status, Object errorDetails, AuthUrlData data, Object infoDtls) {
		super();
		Status = status;
		ErrorDetails = errorDetails;
		this.data = data;
		InfoDtls = infoDtls;
	}

	public Integer getStatus() {
		return Status;
	}

	public void setStatus(Integer status) {
		Status = status;
	}

	public Object getErrorDetails() {
		return ErrorDetails;
	}

	public void setErrorDetails(Object errorDetails) {
		ErrorDetails = errorDetails;
	}

	public AuthUrlData getData() {
		return data;
	}

	public void setData(AuthUrlData data) {
		this.data = data;
	}

	public Object getInfoDtls() {
		return InfoDtls;
	}

	public void setInfoDtls(Object infoDtls) {
		InfoDtls = infoDtls;
	}

	@Override
	public String toString() {
		return "AuthUrlResponse [Status=" + Status + ", ErrorDetails=" + ErrorDetails + ", data=" + data + ", InfoDtls="
				+ InfoDtls + "]";
	}

}
