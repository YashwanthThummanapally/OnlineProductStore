package test;
import java.sql.*;
public class DeleteProductDAO {
	private int k;
	public int removeProduct(ProductBean product) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement delete = con.prepareStatement
					("DELETE FROM PRODUCTOPS WHERE CODE=?");
			
			delete.setString(1, product.getCode());
			k = delete.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}
		return k;
	}
}