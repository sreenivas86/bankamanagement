package bank.user;

import java.util.Scanner;

public class TestClass {
	@SuppressWarnings("unused")
	static Scanner sc=new Scanner (System.in);
	
	
	public static void main(String[] args) {
		Validate r=new Validate();
		
		System.out.println("enter mobile number");
		String n=sc.next();
		//validate(n);
		if(r.validatePassword(n)) {
			System.out.println("valid");
			
		}
		else 
			System.out.println("not Valid");
	}

}
