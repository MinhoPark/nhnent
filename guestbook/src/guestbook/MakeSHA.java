package guestbook;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MakeSHA {
	public static String getSHA1(String input) throws NoSuchAlgorithmException
	{
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		md.update(input.getBytes());
		byte[] digest = md.digest();
		
		StringBuffer sb = new StringBuffer();
		for(byte b : digest){
			sb.append(Integer.toHexString(b & 0xFF));
		}
		
		return sb.toString();
	}
}
