package com.irn.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class IrnGovtUtil {
	public static PublicKey getPublicKey(String pubKey)
			throws FileNotFoundException, IOException, NoSuchAlgorithmException, InvalidKeySpecException {

		pubKey = new String(Base64.decodeBase64(pubKey.getBytes()));

		pubKey = pubKey.replaceAll("(-+BEGIN PUBLIC KEY-+\\r?\\n|-+END PUBLIC KEY-+\\r?\\n?)", "");

		byte[] decodedString = Base64.decodeBase64(pubKey.getBytes());

		X509EncodedKeySpec spec = new X509EncodedKeySpec(decodedString);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PublicKey publicKey = keyFactory.generatePublic(spec);

		return publicKey;
	}

	public static String encryptAsymmentricKey(String pubKey, String jsonData) throws Exception {
		PublicKey publicKeys = getPublicKey(pubKey);
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1PADDING");
		cipher.init(Cipher.ENCRYPT_MODE, publicKeys);
		byte[] encryptedText = cipher.doFinal(jsonData.getBytes());
		String encryptedPassword = Base64.encodeBase64String(encryptedText);
		return encryptedPassword;
	}

	public static String decrptBySymmetricKeySEK(String appKey, String encryptedSek) {
		byte[] byteAppKey = Base64.decodeBase64(appKey);
		Key aesKey = new SecretKeySpec(byteAppKey, "AES");
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, aesKey);
			byte[] encryptedSekBytes = Base64.decodeBase64(encryptedSek);
			byte[] decryptedSekBytes = cipher.doFinal(encryptedSekBytes);
			String decryptedSek = Base64.encodeBase64String(decryptedSekBytes);
			return decryptedSek;
		} catch (Exception e) {
			return "Exception; " + e;
		}
	}

	public static String encryptBySymmetricKey(String json, String sek) {
		byte[] sekByte = Base64.decodeBase64(sek);
		Key aesKey = new SecretKeySpec(sekByte, "AES");
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, aesKey);
			byte[] encryptedjsonbytes = cipher.doFinal(json.getBytes());
			String encryptedJson = Base64.encodeBase64String(encryptedjsonbytes);
			return encryptedJson;
		} catch (Exception e) {
			return "Exception " + e;
		}
	}

	public static String decryptBySymmentricKeyIrnResponse(String data, String decryptedSek) {
		byte[] sekByte = Base64.decodeBase64(decryptedSek);
		Key aesKey = new SecretKeySpec(sekByte, "AES");
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, aesKey);
			byte[] decordedValue = Base64.decodeBase64(data);
			byte[] decValue = cipher.doFinal(decordedValue);
			return new String(decValue);
		} catch (Exception e) {
			return "Exception " + e;
		}
	}
}
