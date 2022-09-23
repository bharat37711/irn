package com.irn.serviceImp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.irn.config.ApiResponseMessagesPropertyConfig;
import com.irn.constrant.Constant;
import com.irn.dao.ClientCredentialDao;
import com.irn.dao.ClientInvoiceIrnInfoDao;
import com.irn.entity.ClientInvoiceIrnInfo;
import com.irn.entity.ClientIrnCredential;
import com.irn.entity.EncrpitData;
import com.irn.request.CancelInvoiceRequest;
import com.irn.request.ClientCredentialRequest;
import com.irn.request.IrnGenrateRequest;
import com.irn.response.AuthUrlData;
import com.irn.response.AuthUrlResponse;
import com.irn.response.CancelInvoiceData;
import com.irn.response.CustomResponse;
import com.irn.response.GenralResponse;
import com.irn.response.IrnGenrateData;
import com.irn.services.IrnGovService;
import com.irn.setter.EntitySetter;
import com.irn.setter.RequestSetter;
import com.irn.util.IrnGovtUtil;

@Service
public class IrnGovServiceImp implements IrnGovService {
	@Autowired
	private RestTemplate template;
	@Autowired
	private ClientInvoiceIrnInfoDao clientInvoiceIrnInfoDao;

	@Autowired
	private ClientCredentialDao clientCredentialDao;

	@Autowired
	private ApiResponseMessagesPropertyConfig responseMessageConfig;

	@Value(value = "${irn.authUrl}")
	private String irnAuthUrl;

	@Value(value = "${irn.irnGenrateUrl}")
	private String irnGenrateUrl;

	@Value(value = "${irn.cancelInvoiceUrl}")
	private String cancelInvoiceUrl;

	@Value(value = "${IrnGovt.getIrnUrl}")
	private String getIrnDetailsUrl;

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	public CustomResponse irnAuthURL(ClientIrnCredential credential) throws Exception {

		ClientCredentialRequest request = RequestSetter.entityToClientCredentialRequest(credential);
		String payload = Base64.encodeBase64String(new Gson().toJson(request).getBytes());

		String publicKeyWithInp = IrnGovtUtil.encryptAsymmentricKey(credential.getBase64EncodedPem(), payload);
		String data = new Gson().toJson(new EncrpitData(publicKeyWithInp));

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set(Constant.CLIENT_ID, credential.getClientId());
		headers.set(Constant.CLIENT_SECRET, credential.getClientSecret());
		headers.set(Constant.GST_IN, credential.getGstIn());

		HttpEntity<String> httpEntity = new HttpEntity<String>(data, headers);

		String response = template.postForEntity(irnAuthUrl, httpEntity, String.class).getBody();

		AuthUrlResponse authUrlResponse = new Gson().fromJson(response, AuthUrlResponse.class);

		if (authUrlResponse.getStatus() == 0) {
			CustomResponse customResponse = new CustomResponse(authUrlResponse.getStatus(), null,
					authUrlResponse.getErrorDetails().toString());
			LOGGER.info(customResponse.toString());
			return customResponse;

		}

		AuthUrlData authUrlData = authUrlResponse.getData();

		credential.setAuthToken(authUrlData.getAuthToken());

		credential.setTokenExpiryTimeStamp(
				new SimpleDateFormat(Constant.DATE_FORMAT_YYY_MM_DD_HH_MM_SS).parse(authUrlData.getTokenExpiry()));
		credential.setSek(authUrlData.getSek());
		clientCredentialDao.save(credential);
		LOGGER.info("DB update  with Company id :" + credential.getClientId());
		return new CustomResponse(authUrlResponse.getStatus(), credential, null);

	}

	public CustomResponse irnGenrateURL(Integer companyId, IrnGenrateRequest irnGenrate) {
		try {
			ClientIrnCredential credential = clientCredentialDao.getbyClientId(companyId);

			CustomResponse customResponse = null;
			if (credential == null) {
				customResponse = new CustomResponse(0, responseMessageConfig.getProperty("Master.EmptyList"),
						"Company doesn't exist with id : " + companyId);
				LOGGER.error(customResponse.toString());
				return customResponse;
			}

			if (new Date().after(credential.getTokenExpiryTimeStamp())) {
				customResponse = this.irnAuthURL(credential);
				if (customResponse.getStatus() == 0) {
					return customResponse;
				}
				credential = (ClientIrnCredential) customResponse.getData();
			}

			String jsonString = new Gson().toJson(irnGenrate);

			String decriptedSek = IrnGovtUtil.decrptBySymmetricKeySEK(credential.getAppKey(), credential.getSek());

			String encriptData = new Gson()
					.toJson(new EncrpitData(IrnGovtUtil.encryptBySymmetricKey(jsonString, decriptedSek)));
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.set(Constant.CLIENT_ID, credential.getClientId());
			headers.set(Constant.CLIENT_SECRET, credential.getClientSecret());
			headers.set(Constant.GST_IN, credential.getGstIn());
			headers.set(Constant.USER_NAME, credential.getUserName());
			headers.set(Constant.AUTH_TOKEN, credential.getAuthToken());

			HttpEntity<String> httpEntity = new HttpEntity<String>(encriptData, headers);
			String response = template.postForEntity(this.irnGenrateUrl, httpEntity, String.class).getBody();

			GenralResponse genralResponse = new Gson().fromJson(response, GenralResponse.class);

			if (genralResponse.getStatus() == 0) {

				customResponse = this.getIrnDetails(response, credential, decriptedSek);
				LOGGER.info(customResponse.toString());
				return customResponse;
			}

			String responseData = IrnGovtUtil.decryptBySymmentricKeyIrnResponse(genralResponse.getData(), decriptedSek);

			IrnGenrateData irnGenrateData = new Gson().fromJson(responseData, IrnGenrateData.class);

			clientInvoiceIrnInfoDao.save(EntitySetter.irnGenrateDataToEntity(irnGenrateData));
			customResponse = new CustomResponse(genralResponse.getStatus(), irnGenrateData, null);
			LOGGER.info(irnGenrateData.toString());
			return customResponse;
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(ExceptionUtils.getStackTrace(e));
			return new CustomResponse(0, null, e.getCause().toString());
		}

	}

	public CustomResponse cancelIrnWithClientInvoiceId(CancelInvoiceRequest cancelInvoiceRequest) {

		ClientIrnCredential credential = clientCredentialDao.getbyClientId(cancelInvoiceRequest.getCompanyId());
		CustomResponse customResponse = null;
		try {
			if (credential == null) {
				customResponse = new CustomResponse(0, null,
						responseMessageConfig.getProperty("Master.GetNotFoundMessage"));
				LOGGER.error(customResponse.toString());
				return customResponse;
			}

			if (new Date().after(credential.getTokenExpiryTimeStamp())) {
				customResponse = this.irnAuthURL(credential);
				if (customResponse.getStatus() == 0) {
					return customResponse;
				}
				credential = (ClientIrnCredential) customResponse.getData();
			}

			ClientInvoiceIrnInfo invoiceIrnInfo = clientInvoiceIrnInfoDao
					.getIrnByClientInvoiceId(cancelInvoiceRequest.getClientInvoiceId());

			String decriptedSek = IrnGovtUtil.decrptBySymmetricKeySEK(credential.getAppKey(), credential.getSek());

			cancelInvoiceRequest.setIrn(invoiceIrnInfo.getIrn());

			String jsonString = new Gson().toJson(cancelInvoiceRequest);

			String encriptData = new Gson()
					.toJson(new EncrpitData(IrnGovtUtil.encryptBySymmetricKey(jsonString, decriptedSek)));

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.set(Constant.CLIENT_ID, credential.getClientId());
			headers.set(Constant.CLIENT_SECRET, credential.getClientSecret());
			headers.set(Constant.GST_IN, credential.getGstIn());
			headers.set(Constant.USER_NAME, credential.getUserName());
			headers.set(Constant.AUTH_TOKEN, credential.getAuthToken());

			HttpEntity<String> httpEntity = new HttpEntity<String>(encriptData, headers);

			String response = template.postForEntity(this.cancelInvoiceUrl, httpEntity, String.class).getBody();

			GenralResponse genralResponse = new Gson().fromJson(response, GenralResponse.class);

			if (genralResponse.getStatus() == 0) {
				customResponse = new CustomResponse(0, genralResponse.getErrorDetails().toString());

				LOGGER.info(customResponse.toString());
				return customResponse;
			}

			String responseData = IrnGovtUtil.decryptBySymmentricKeyIrnResponse(genralResponse.getData(), decriptedSek);

			CancelInvoiceData cancelInvoiceData = new Gson().fromJson(responseData, CancelInvoiceData.class);

			invoiceIrnInfo.setIrn(cancelInvoiceData.getIrn());
			invoiceIrnInfo.setCancelDate(new SimpleDateFormat(Constant.DATE_FORMAT_YYY_MM_DD_HH_MM_SS)
					.parse(cancelInvoiceData.getCancelDate()));
			invoiceIrnInfo.setCancelReason(cancelInvoiceRequest.getCnlRsn());
			invoiceIrnInfo.setCancelRemark(cancelInvoiceRequest.getCnlRem());
			clientInvoiceIrnInfoDao.save(invoiceIrnInfo);
			customResponse = new CustomResponse(genralResponse.getStatus(), cancelInvoiceData, null);

			LOGGER.info(customResponse.toString());
			return customResponse;
		} catch (Exception e) {
			LOGGER.error(ExceptionUtils.getStackTrace(e));
			return new CustomResponse(0, e.getCause().toString());
		}

	}

	public CustomResponse getIrnDetails(String infoDetails, ClientIrnCredential credential, String decriptedSek)
			throws ParseException {
		String s = infoDetails.replace('"', '!');
		List<String> list = Arrays.asList(s.split("!"));
		String errorCode = list.get(list.indexOf("ErrorCode") + 2);

		if (errorCode.equals("2150") || errorCode.equals("2278")) {
			String irn = list.get(list.indexOf("Irn") + 2);
			ClientInvoiceIrnInfo invoiceInfoFromDb = clientInvoiceIrnInfoDao.getInvoiceInfoByIrn(irn);

			if (invoiceInfoFromDb == null) {
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
				headers.set(Constant.CLIENT_ID, credential.getClientId());
				headers.set(Constant.CLIENT_SECRET, credential.getClientSecret());
				headers.set(Constant.GST_IN, credential.getGstIn());
				headers.set(Constant.USER_NAME, credential.getUserName());
				headers.set(Constant.AUTH_TOKEN, credential.getAuthToken());

				HttpEntity<Void> httpEntity = new HttpEntity<Void>(headers);

				String response = template
						.exchange(this.getIrnDetailsUrl + irn, HttpMethod.GET, httpEntity, String.class).getBody();

				GenralResponse genralResponse = new Gson().fromJson(response, GenralResponse.class);

				if (genralResponse.getStatus() == 0) {
					CustomResponse customResponse = new CustomResponse(0, genralResponse.getErrorDetails(), null);
					LOGGER.error(customResponse.toString());
					return customResponse;
				}

				String responseData = IrnGovtUtil.decryptBySymmentricKeyIrnResponse(genralResponse.getData(),
						decriptedSek);
				IrnGenrateData irnGenrateData = new Gson().fromJson(responseData, IrnGenrateData.class);

				clientInvoiceIrnInfoDao.save(EntitySetter.irnGenrateDataToEntity(irnGenrateData));
				CustomResponse customResponse = new CustomResponse(1, irnGenrateData, null);
				LOGGER.info(customResponse.toString());
				return customResponse;

			}
			CustomResponse customResponse = new CustomResponse(1, invoiceInfoFromDb, null);
			LOGGER.info(customResponse.toString());
			return customResponse;

		}
		CustomResponse customResponse = new CustomResponse(0, infoDetails, null);
		LOGGER.info(customResponse.toString());
		return customResponse;

	}

}
