package bank.user;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Dob {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter ur name");
		String name=sc.nextLine();
		System.out.println("enter ur dob (yyyy-mm-dd)");
		String dob=sc.next();
		sc.close();
		
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String driver="oracle.jdbc.driver.OracleDriver";
		String uName="sree";
		String pwd="sree";
		try {
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url,uName,pwd);
			String query="insert into dob values(?,?)";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1, name);
			Date date=Date.valueOf(dob);
			pst.setDate(2, date);
			pst.executeUpdate();
			System.out.println("upload sucessfully");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
	}
}
