package test;
import java.sql.*;
public class UpdateProductDAO {
	private int k;
	public int update(ProductBean product) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement update = con.prepareStatement
					("UPDATE PRODUCTOPS SET PRICE=?,QTY=? WHERE CODE=?");
			
			update.setFloat(1, product.getPrice());
			update.setInt(2, product.getQuantity());
			update.setString(3, product.getCode());
			k = update.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}
		return k;
	}
}