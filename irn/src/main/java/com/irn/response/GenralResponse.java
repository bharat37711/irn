package com.irn.response;

public class GenralResponse {
	Integer Status;
	Object ErrorDetails;
	String Data;
	Object InfoDtls;

	public GenralResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GenralResponse(Integer status, Object errorDetails, String data, Object infoDtls) {
		super();
		Status = status;
		ErrorDetails = errorDetails;
		Data = data;
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

	public String getData() {
		return Data;
	}

	public void setData(String data) {
		Data = data;
	}

	public Object getInfoDtls() {
		return InfoDtls;
	}

	public void setInfoDtls(Object infoDtls) {
		InfoDtls = infoDtls;
	}

	@Override
	public String toString() {
		return "GenralResponse [Status=" + Status + ", ErrorDetails=" + ErrorDetails + ", Data=" + Data + ", InfoDtls="
				+ InfoDtls + "]";
	}

}
