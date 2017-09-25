package kali.jersey;

public class Validator {
	public static boolean validate(UserParse up){
		if(up.getPass().equals(""))
			return false;
		if(up.getUser().equals(""))
			return false;
		return true;
	}
	
	public static boolean validateUD(UpdateUserParse up){
		if(up.getPass().equals(""))
			return false;
		if(up.getUser().equals(""))
			return false;
		if(up.getNewPass().equals(""))
			return false;
		if(up.getNewUser().equals(""))
			return false;
		return true;
	}
	
	
}
