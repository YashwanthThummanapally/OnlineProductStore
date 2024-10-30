package test;
import java.sql.*;
public class UpdateCustomerProfileDAO {
	private int k;
	
	public int update(CustomerBean cust) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement update = con.prepareStatement
					("UPDATE CUSTOMEROPS SET ADDR=?,MAIL=?,PHNO=? WHERE UNAME=? AND PASSWORD=?");
			
			update.setString(1, cust.getAddress());
			update.setString(2, cust.getMailId());
			update.setLong(3, cust.getPhoneNumber());
			update.setString(4, cust.getUsername());
			update.setString(5, cust.getPassword());
			k = update.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}
		return k;
	}
}