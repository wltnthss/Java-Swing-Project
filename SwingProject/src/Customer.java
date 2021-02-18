import java.sql.DriverManager;

import com.sun.jdi.connect.spi.Connection;

public class Customer {
	public static void main(String[] args) {
		
		
		
	}
	
	public static Connection getConnection() {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url =  "jdbc:mysql://sql5.freemysqlhosting.net:3306/sql5393725";
			String user = "sql5393725";
			String pass= "245ucuHLst";
			Class.forName(driver);
			Connection connection = (Connection) DriverManager.getConnection(url, user, pass);
			System.out.println("The Connection Successful");
			return connection;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}	
}
