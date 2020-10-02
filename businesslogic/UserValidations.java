package businesslogic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidations {
	
	public boolean isNumber(long num) {
		int number = String.valueOf(num).length();
		if(number==10)
		{
			return true;
		}
		else {
			return false;
		}
		
	}
	public String phoneNumberWarrning(boolean isValid) {
		
		if(!isValid)
		{
			return "Please enter correct Phone Number";
		}
		else {
			return "Correct Phone Number";
		}
	}
		public boolean isAge(int age) {
			if (age>18) {
				
				return true;
				
			} else {
				
				return false;
			}
			
		}
		
		public String isAgeWarning(boolean age) {
			if (age) {
				return "You are eligible to open an account.!";
				
			} else {
				return "You are not eligible to open an account.!";
			}
			
		}
		
		public boolean isValidPassword(String password)
		{
			if (password == null ) 
	            return false; 
			else {
				 
				 String strongPass = "^(?=.*[0-9])"
	                       + "(?=.*[a-z])(?=.*[A-Z])"
	                       
	                       + "(?=\\S+$).{8,20}$";
				 Pattern pat = Pattern.compile(strongPass); 
				  Matcher m = pat.matcher(password); 
	  
			        
			        boolean valid=m.matches(); 
			      
			        if(valid )
			        {
			        	return true;
			        }
			        else {
			        	return false;
					}
			        
			}
			
		    }
		
		public String passwordWarrining(boolean isPass) {
			
			if (isPass) {
				
				return "Perfect Password Buddy.!";
				
			} else {

				return "For Security concerns atleast include 1 numeric,1 upper and lower case and a Special character and length of 8 characters Buddy.!";
			}
			
		}

}
