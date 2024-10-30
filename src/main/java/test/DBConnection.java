package test;
import java.sql.*;
public class DBConnection {
	private static Connection con;

	private DBConnection() {}
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(DBInfo.url, DBInfo.username, DBInfo.password);
		}catch(Exception e) {e.printStackTrace();}
	}
	
	public static Connection getCon() {
		return con;
	}
}