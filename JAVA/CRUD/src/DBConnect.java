import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	
	final static String url = "jdbc:mysql://localhost:3306/db_test";
	final static String user = "admin";
	final static String password = "admin";
	
	public static Connection conn;

	public static Connection getConn() {
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println("Connection Failed...");
			e.printStackTrace();
		}
		
		return conn;
	}
}
