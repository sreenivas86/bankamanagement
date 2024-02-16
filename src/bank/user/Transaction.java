package bank.user;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Transaction  implements Transactions {
	static BankOperations b=new BankOperations();
	
	@Override
	public void withDraw(int ammount) {
		if(ammount>getAmmount(b.getAccountNum()))
			System.out.println("your balance is low");
		int totalAmount=(getAmmount(b.getAccountNum()))-ammount;
		setbalance(totalAmount,b.getAccountNum());
	}

	@Override
	public void deposit(int amount) {
		int totalAmount=amount+getAmmount(b.getAccountNum());
		setbalance(totalAmount,b.getAccountNum());
		System.out.println("success");
	}

	@Override
	public void checkBalance() {
		System.out.println("you balance is :"+getAmmount(b.getAccountNum() ));
	}

	@SuppressWarnings("resource")
	@Override
	public void sendMoney() {
		int ammount;
		System.out.println("enter  account number");
		long mno=(new Scanner(System.in)).nextLong();
		if(getAvailable(mno)) {
			System.out.println("enter ur ammount");
			 ammount=(new Scanner(System.in)).nextInt();
			if(ammount>getAmmount(b.getAccountNum())){
				System.out.println("Insufficient balance");
			}
			else {
				setbalance(ammount,mno);
				System.out.println(" send sucsesfully ");
			}
		}

	}
	private int getAmmount(long acno) {
		int balance=0;
		String query="select balance from bankuser where MOBILE_NO="+acno;
		try {
			PreparedStatement pst=(DataBase.con()).prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				 balance=rs.getInt(1);
			}
		} catch (Exception e) {
			
			System.out.println(e);
		}
		return balance;
	}
	private void setbalance(int balance, long acNumber) {
		String query="update bankuser set balance=? where MOBILE_NO="+acNumber;
		try {
			PreparedStatement pst=(DataBase.con()).prepareStatement(query);
			pst.setInt(7, balance);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	private boolean getAvailable(long acno) {
		String query ="select MOBILE_NO from bankuser where MOBILE_NO= "+acno;
		try {
			Statement st=(DataBase.con()).createStatement();
			ResultSet rs=st.executeQuery(query);
			long mno=0;
			while(rs.next()) {
				 mno=rs.getLong(0);
				
			}
			if(mno==acno&& acno!=b.getAccountNum())
				return true;
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return false;
	}
}
