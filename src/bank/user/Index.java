package bank.user;
import java.util.*;

public class Index {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		Bank bank=new BankOperations();
		try {
			System.out.println( "***Bank Management System***");
			System.out.println("1.login"
					+ "\n2.register"
					+ "\n3.Exit");
			System.err.println("Note:\n 1.You have account you will chose Login(1) and OtherWise you will choose register(2)"
					+ "\n2.Enter only numbers");
			System.out.println("Enter your otion");
			int option=sc.nextInt();
			if(option==1) {
				System.out.println("login here");
				bank.login();
			}
			else if(option==2) {
				System.out.println("register here");
				bank.register();
				

			}
			else if(option==3) {
				System.out.println("close sucessfully");
				return;
			}
			else
				System.err.println("please choose valid Option");

		

	} catch (Exception e) {
		System.out.println("the error is"+e);
	}
}
}
