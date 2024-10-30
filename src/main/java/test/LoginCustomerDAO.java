package test;
import java.sql.*;
public class LoginCustomerDAO {
	private CustomerBean cust;
	
	public CustomerBean login(String username, String password) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement select = con.prepareStatement
					("SELECT * FROM CUSTOMEROPS WHERE UNAME=? AND PASSWORD=?");
			
			select.setString(1, username);
			select.setString(2, password);
			ResultSet rs = select.executeQuery();
			
			if(rs.next()) {
				cust = new CustomerBean();
				cust.setUsername(rs.getString(1));
				cust.setPassword(rs.getString(2));
				cust.setFirstName(rs.getString(3));
				cust.setLastName(rs.getString(4));
				cust.setAddress(rs.getString(5));
				cust.setMailId(rs.getString(6));
				cust.setPhoneNumber(rs.getLong(7));
			}
		}catch(Exception e) {e.printStackTrace();}
		return cust;
	}
}