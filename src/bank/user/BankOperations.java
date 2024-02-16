package bank.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class BankOperations implements Bank {
	static Scanner sc=new Scanner(System.in);
	Transactions t=new Transaction();
	private long accountNum;
	public long getAccountNum() {
		return accountNum;
	}

	@Override
	public void register() {
		int amount=0;
		
		Validate val=new Validate();
		System.out.println("\t welocome to register form\n");
		System.out.println("Enter your name:");
		String name=sc.nextLine();
		System.out.println("Enter your mobileNumber ");
		String mobileNumber=sc.next();
		System.out.println("Enter your email id");
		
		String email=sc.next();
		System.out.println("Enter your age");
		System.err.println("Note:age is not lessthan 10 and greater than 98");
		String age=sc.next();
		System.out.println("enter password");
		System.err.println("NOTE:"
				+ "\n Enter atleast one uppercase, lowewe case,digit and @#$% and more than 8 charectars");
		String password=sc.next();
		System.out.println("Enter your addres");
		System.err.println("NOTE:the address is atlest 8 charecters and not more than 50 charecters");
		String addres=sc.nextLine();
		sc.hasNext();
		System.out.println("please wait processing");
		long mobileNum=Long.parseLong(mobileNumber);
		int ag=Integer.parseInt(age);
		
		if(val.validateName(name)&&val.validateAge(age)&&val.validateEMail(email)&&val.validateMNo(mobileNumber)&& val.validatePassword(password)) {
			try {
				registerDb(name, mobileNum, email, ag, addres,password,amount);
				System.out.println("sucsessfully Registered");
				login();
			} catch (ClassNotFoundException e) {
				
				System.out.println(e);
			} catch (Exception e) {
				
				e.printStackTrace();
			} 
			
			
		}
		else {
			System.err.println("enter valid details");
		}
		
		
		

	}

	@Override
	public void login() {
		System.out.println("Login Here");
		System.out.println("enter mobile number");
		long mno=sc.nextLong();
		this.accountNum=mno;
		System.out.println("Enter password");
		String password=sc.next();
		validateLogin(mno,password);
		run();

	}
	private void validateLogin(long mno,String password) {
		
		try {
			Connection con=DataBase.con();
			String query=" select password from bankuser where mobile_no="+mno;
			PreparedStatement pst=con.prepareStatement(query);
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				if((rs.getString(1)).equals(password)) {
					System.out.println("login ssucessfully");
				}
				else
					System.out.println("enter valid password");
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	public void registerDb(String name,Long mno,String mail,int a,String address,String pw, int amount) throws ClassNotFoundException, Exception {
		Connection con=DataBase.con();
		String query="insert into Bankuser values(?,?,?,?,?,?)";
		PreparedStatement pst=con.prepareStatement(query);
		pst.setString(1, name);
		pst.setLong(2, mno);
		pst.setString(3, mail);
		pst.setInt(4, a);
		pst.setString(5, address);
		pst.setString(6, pw);
		pst.setInt(7, amount);
		pst.executeUpdate();
		
		
				
	}
	private void run() {
		int ammount;
		do {
			System.out.println("1.Deposit\n"
					+ "2.withdraw"
					+ "3.Check Balance"
					+ "4.Transfer money"
					+ "5.logout");
			System.out.println("choose your otion");
			int key=sc.nextInt();
			switch (key) {
			case 1:
				System.out.println("enter deposit  ammount");
				ammount=sc.nextInt();
				t.deposit(ammount);
				System.out.println("sucsessfully credited");
				break;
			case 2:
				System.out.println("enter withdraw ammount");
				ammount=sc.nextInt();
				t.withDraw(ammount);
				System.out.println("sucsessfully debited");
				break;
			case 3:
				t.checkBalance();
				break;
			case 4:
				t.sendMoney();
				break;
			case 5:
				System.out.println("successfully logout");
				System.exit(0);
				break;
			default:
				System.out.println("enter valid otion");
				break;
			}
		} while (true);
	}

	
	

}
