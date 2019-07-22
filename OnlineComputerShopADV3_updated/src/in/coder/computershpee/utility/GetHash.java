package in.coder.computershpee.utility;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GetHash {
	
	public static String stringToHash(String input) throws NoSuchAlgorithmException
	{
		MessageDigest digestObject = MessageDigest.getInstance("SHA-256");
		
		byte [] hashByteArray = digestObject.digest(input.getBytes());
		
		BigInteger hashByteInteger = new BigInteger(hashByteArray);
		
		//System.out.println("ABC".hashCode());
		
		return hashByteInteger.toString(16);
	}
	public static void main(String[] args) throws NoSuchAlgorithmException {
		
		//System.out.println(stringToHash("admin"));
		
		
	}
}
