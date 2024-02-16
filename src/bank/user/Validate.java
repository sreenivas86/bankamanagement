package bank.user;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
	
	private  static Pattern p;
	private  static Matcher m;

	public boolean validateName(String name) {
		p=Pattern.compile("[a-z A-Z]*");
		m=p.matcher(name);
		if(m.find()&&m.group().equals(name)) {
			
			return true;
		}
		return false;
	}
	public boolean validateAge(String age) {
		p=Pattern.compile("[1-9]?[1-9]");
		m=p.matcher(age);
		if(m.find()&&m.group().equals(age))
			return true;
		return false;
		
	}
	public boolean validateEMail(String email) {
		p=Pattern.compile("[a-zA-z0-9][a-zA-Z0-9]*@gmail[.]com");
		m=p.matcher(email);
		if(m.find()&&m.group().equals(email))
			return true;
		return false;
	}
	public boolean validateMNo(String mno) {
		p=Pattern.compile("[6-9][0-9]{9}");
		m=p.matcher(mno);
		if(m.find()&&m.group().equals(mno))
			return true;
		return false;
	}
	public boolean validatePassword(String pw) {
		String regex="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%])(?=\\S+$).{8,20}";
		p=Pattern.compile(regex);
		m=p.matcher(pw);
		if(m.find()&& m.group().equals(pw))
			return true;
		return false;
		
	}
	
		
	
	//long mobileNumber=Long.parseLong(mno);
	//int age1=Integer.parseInt(age);
}
