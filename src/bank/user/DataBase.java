package bank.user;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {
	private static String driver="oracle.jdbc.driver.OracleDriver";
	private static String url="jdbc:oracle:thin:@localhost:1521:orcl";
	private static String userName="sree";
	private static String password="sree";
	
	
	public static Connection con() throws ClassNotFoundException, Exception {
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url,userName,password);
		return con;
	}

}
