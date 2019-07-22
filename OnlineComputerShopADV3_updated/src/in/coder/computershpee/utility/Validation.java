package in.coder.computershpee.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
	
	/*public static boolean validateEmail(String Email)
	{
	
	Pattern p=Pattern.compile("[a-zA-z0-9.&]+@[a-z]+[.][a-z]+[.]{0-1}[a-z]+$");
	Matcher m=p.matcher(Email);
	if(m.find())
	{
		return true;
	}
	return false;*/
	
	public static boolean validateEmail(String email)
	{
		Pattern p = Pattern.compile("[a-zA-Z]^[a-zA-Z0-9.]+@[a-z]+[.]([a-z.]{2,6})$");
		Matcher m = p.matcher(email);
		
		if(m.find())
		{
			 return true;
		}
		return false;
	}
	
	public static boolean validateMobile(String email)
	{
		Pattern p = Pattern.compile("[7-9]^[0-9]{9}$");
		Matcher m = p.matcher(email);
		
		if(m.find())
		{
			 return true;
		}
		
		return false;
	}
	
	public static boolean validateName(String name)
	{
	
	Pattern p=Pattern.compile("[a-zA-z]^[a-zA-Z]*");
	Matcher m=p.matcher(name);
	if(m.find())
	{
		return true;
	}
	return false;
}
	
	public static boolean validatePassword(String password)
	{
	
	Pattern p=Pattern.compile("[a-zA-z &@]{8,16}");
	Matcher m=p.matcher(password);
	if(m.find())
	{
		return true;
	}
	return false;
}

}
