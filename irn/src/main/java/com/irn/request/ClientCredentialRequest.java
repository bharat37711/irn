package com.irn.request;

public class ClientCredentialRequest {

	private boolean forceRefreshAccessToken;
	private String appKey;
	private String userName;
	private String password;

	public ClientCredentialRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClientCredentialRequest(boolean forceRefreshAccessToken, String appKey, String userName, String password) {
		super();
		this.forceRefreshAccessToken = forceRefreshAccessToken;
		this.appKey = appKey;
		this.userName = userName;
		this.password = password;
	}

	public boolean isForceRefreshAccessToken() {
		return forceRefreshAccessToken;
	}

	public void setForceRefreshAccessToken(boolean forceRefreshAccessToken) {
		this.forceRefreshAccessToken = forceRefreshAccessToken;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "ClientCredentialRequest [forceRefreshAccessToken=" + forceRefreshAccessToken + ", appKey=" + appKey
				+ ", userName=" + userName + ", password=" + password + "]";
	}

}
