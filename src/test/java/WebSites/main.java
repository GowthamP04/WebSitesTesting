package WebSites;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class main {

	private static final String ALGORITHM = "AES";
	
	public static String decrypt(String encryptedData, String key) throws Exception {
		SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		byte[] decryptedData = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
		return new String(decryptedData);
		}

		public static String encrypt(String data, String key) throws Exception {
		SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		byte[] encryptedData = cipher.doFinal(data.getBytes());
		return Base64.getEncoder().encodeToString(encryptedData);

		}
		public static void main(String[] args) throws Exception {
			
			String key="q8kZWlKAkpgyWfBaL7QqzA==";
			
			String dataencrypt1=encrypt("gowtham",key);
			System.out.println(dataencrypt1);
			
			String dataencrypt2=encrypt("gowthamkishore004@gmail.com",key);
			System.out.println(dataencrypt2);
			
			String dataencrypt3=encrypt("Gowtham@2000",key);
			System.out.println(dataencrypt3);
			
			String datadecrypt1=decrypt(dataencrypt1,key);
			System.out.println(datadecrypt1);
			
			String datadecrypt2=decrypt(dataencrypt2,key);
			System.out.println(datadecrypt2);
			
			String datadecrypt3=decrypt(dataencrypt3,key);
			System.out.println(datadecrypt3);
		}
		
}