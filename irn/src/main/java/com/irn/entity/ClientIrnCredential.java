package com.irn.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client_irn_credential")
public class ClientIrnCredential {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String userName;
	@Column(name = "password")
	private String password;
	@Column(name = "app_key")
	private String appKey;
	@Column(name = "force_refresh_access_token")
	private Boolean forceRefreshAccessToken;
	@Column(name = "client_id")
	private String clientId;
	@Column(name = "client_secret")
	private String clientSecret;
	@Column(name = "gstin")
	private String gstIn;
	@Column(name = "sek")
	private String Sek;
	@Column(name = "base64_encoded_pem")
	private String base64EncodedPem;
	@Column(name = "auth_token")
	private String AuthToken;
	@Column(name = "token_expiry_timestamp")
	private Date tokenExpiryTimeStamp;
	@Column(name = "company_id")
	private int companyId;
	@Column(name = "is_active")
	private Boolean isActive;

	public ClientIrnCredential() {
		super();
	}

	public ClientIrnCredential(int id, String userName, String password, String appKey, Boolean forceRefreshAccessToken,
			String clientId, String clientSecret, String gstIn, String sek, String base64EncodedPem, String authToken,
			Date tokenExpiryTimeStamp, int companyId, Boolean isActive) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.appKey = appKey;
		this.forceRefreshAccessToken = forceRefreshAccessToken;
		this.clientId = clientId;
		this.clientSecret = clientSecret;
		this.gstIn = gstIn;
		Sek = sek;
		this.base64EncodedPem = base64EncodedPem;
		AuthToken = authToken;
		this.tokenExpiryTimeStamp = tokenExpiryTimeStamp;
		this.companyId = companyId;
		this.isActive = isActive;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public Boolean getForceRefreshAccessToken() {
		return forceRefreshAccessToken;
	}

	public void setForceRefreshAccessToken(Boolean forceRefreshAccessToken) {
		this.forceRefreshAccessToken = forceRefreshAccessToken;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getGstIn() {
		return gstIn;
	}

	public void setGstIn(String gstIn) {
		this.gstIn = gstIn;
	}

	public String getSek() {
		return Sek;
	}

	public void setSek(String sek) {
		Sek = sek;
	}

	public String getBase64EncodedPem() {
		return base64EncodedPem;
	}

	public void setBase64EncodedPem(String base64EncodedPem) {
		this.base64EncodedPem = base64EncodedPem;
	}

	public String getAuthToken() {
		return AuthToken;
	}

	public void setAuthToken(String authToken) {
		AuthToken = authToken;
	}

	public Date getTokenExpiryTimeStamp() {
		return tokenExpiryTimeStamp;
	}

	public void setTokenExpiryTimeStamp(Date tokenExpiryTimeStamp) {
		this.tokenExpiryTimeStamp = tokenExpiryTimeStamp;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "ClientIrnCredential [id=" + id + ", userName=" + userName + ", password=" + password + ", appKey="
				+ appKey + ", forceRefreshAccessToken=" + forceRefreshAccessToken + ", clientId=" + clientId
				+ ", clientSecret=" + clientSecret + ", gstIn=" + gstIn + ", Sek=" + Sek + ", base64EncodedPem="
				+ base64EncodedPem + ", AuthToken=" + AuthToken + ", tokenExpiryTimeStamp=" + tokenExpiryTimeStamp
				+ ", companyId=" + companyId + ", isActive=" + isActive + "]";
	}

}
