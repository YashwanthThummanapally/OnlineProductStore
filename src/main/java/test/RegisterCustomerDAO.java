package test;
import java.sql.*;
public class RegisterCustomerDAO {
	private int k;
	
	public int registerCustomer(CustomerBean cust) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement insert = con.prepareStatement
					("INSERT INTO CUSTOMEROPS VALUES(?,?,?,?,?,?,?)");
			
			insert.setString(1, cust.getUsername());
			insert.setString(2, cust.getPassword());
			insert.setString(3, cust.getFirstName());
			insert.setString(4, cust.getLastName());
			insert.setString(5, cust.getAddress());
			insert.setString(6, cust.getMailId());
			insert.setLong(7, cust.getPhoneNumber());
			k = insert.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}
		return k;
	}
}