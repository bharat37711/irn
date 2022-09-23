package com.irn.response;

public class CustomResponse {

	private Integer status;

	private Object data;

	private String error;

	public CustomResponse() {
		super();
	}

	public CustomResponse(Integer status, String error) {
		super();
		this.status = status;
		this.error = error;
	}

	public CustomResponse(Integer status, Object data, String error) {
		super();
		this.status = status;
		this.data = data;

		this.error = error;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "CustomResponse [status=" + status + ", data=" + data + ", error=" + error + "]";
	}

}
