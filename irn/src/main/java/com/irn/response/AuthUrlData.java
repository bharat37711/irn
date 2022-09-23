package com.irn.response;

public class AuthUrlData {

	String ClientId;

	String UserName;

	String AuthToken;

	String Sek;

	String TokenExpiry;

	public AuthUrlData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthUrlData(String clientId, String userName, String authToken, String sek, String tokenExpiry) {
		super();
		ClientId = clientId;
		UserName = userName;
		AuthToken = authToken;
		Sek = sek;
		TokenExpiry = tokenExpiry;
	}

	public String getClientId() {
		return ClientId;
	}

	public void setClientId(String clientId) {
		ClientId = clientId;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getAuthToken() {
		return AuthToken;
	}

	public void setAuthToken(String authToken) {
		AuthToken = authToken;
	}

	public String getSek() {
		return Sek;
	}

	public void setSek(String sek) {
		Sek = sek;
	}

	public String getTokenExpiry() {
		return TokenExpiry;
	}

	public void setTokenExpiry(String tokenExpiry) {
		TokenExpiry = tokenExpiry;
	}

}
