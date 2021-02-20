import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Connection;

public class Customer {
//	public static void main(String[] args) {
//		createTable();	
//		// Test code
//		createCustomer("son", "010-1111-1111", "Male", "27", "This is Note");
//		ArrayList<String> list = getCustomers();
//		// ArrayList를 item에 담아 사용
//		for(String item: list) {	
//			System.out.println(item);
//		}
//		createCustomer("Park", "010-2222-2222", "Female", "28", "VIP Customer");
//		list = getCustomers();
//		for(String item: list) {
//			System.out.println(item);
//		}
//	}
	
	public static String[][] getCustomers(){
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("Select name, phone, gender, age, note FROM customer");
			ResultSet results = statement.executeQuery();
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(results.next()) {
				list.add(new String[] {
							results.getString("name"),
							results.getString("phone"),
							results.getString("gender"),
							results.getString("age"),
							results.getString("note")
				});
			}
			System.out.println("The data has been fetched!");
			String[][] arr = new String[list.size()][5];
			return list.toArray(arr);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}		
	}
	
	public static void createCustomer (String name, String phone, String gender, String age, String note) {
		try {
			Connection con = getConnection();
			PreparedStatement insert = con.prepareStatement(""
						+ "INSERT INTO customer"
						+ "(name, phone, gender, age, note) "
						+ "VALUE "
						+ "('"+name+"','"+phone+"','"+gender+"','"+age+"','"+note+"')"); 
					// (name, phone, gender, age, note) 데이터 삽입
				insert.executeUpdate();
				// Test code
				System.out.println("The data has been saved!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("INSERT SQL 에러 발생");

		}
	}
	
	// 테이블 생성
	public static void createTable() {
		try {
			Connection con = getConnection();
			PreparedStatement create = con.prepareStatement(
					  "CREATE TABLE IF NOT EXISTS "
					+ "customer(id int NOT NULL AUTO_INCREMENT,"
					+ "name varChar(255),"
					+ "phone varChar(255),"
					+ "gender varChar(255),"
					+ "age varChar(255),"
					+ "note varChar(255),"
					+ "PRIMARY KEY(id))");
				create.execute();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("CREATE SQL 에러 발생");
		} finally {
			System.out.println("테이블 생성 완료");
		}
	}
	
	public static Connection getConnection() {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url =  "jdbc:mysql://sql5.freemysqlhosting.net:3306/sql5393725";
			String user = "sql5393725";
			String pass= "245ucuHLst";
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, user, pass);
			System.out.println("Driver successfully connected!");
			return con;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}	
}
