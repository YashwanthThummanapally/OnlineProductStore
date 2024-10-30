package test;
import java.sql.*;
public class UpdateCustomerBuyProductDAO {
	private int k;
	
	public int update(ProductBean product) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement update = con.prepareStatement
					("UPDATE PRODUCTOPS SET QTY=? WHERE CODE=?");
			
			update.setInt(1, product.getQuantity());
			update.setString(2, product.getCode());
			k = update.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}
		return k;
	}
}