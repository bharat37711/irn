package com.irn.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EncrpitData {
	@JsonProperty("Data")
	private String Data;

	public EncrpitData() {
		super();

	}

	public EncrpitData(String data) {
		super();
		Data = data;
	}

	public String getData() {
		return Data;
	}

	public void setData(String data) {
		Data = data;
	}

	@Override
	public String toString() {
		return "EncrpitData [Data=" + Data + "]";
	}

}
