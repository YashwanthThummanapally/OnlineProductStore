package test;
import java.sql.*;
public class AdminLoginDAO {
	private AdminBean admin;
	public AdminBean login(String username, String password) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement select = con.prepareStatement
					("SELECT * FROM ADMINOPS WHERE UNAME=? AND PASSWORD=?");
			
			select.setString(1, username);
			select.setString(2, password);
			ResultSet rs = select.executeQuery();
			
			if(rs.next()) {
				admin = new AdminBean();
				admin.setUsername(rs.getString(1));
				admin.setPassword(rs.getString(2));
				admin.setFirstName(rs.getString(3));
				admin.setLastName(rs.getString(4));
				admin.setAddress(rs.getString(5));
				admin.setMail(rs.getString(6));
				admin.setPhoneNumber(rs.getLong(7));
			}
		}catch(Exception e) {e.printStackTrace();}
		return admin;
	}
}