package test;
import java.sql.*;
public class AddProductDAO {
	private int k;
	public int insertProduct(ProductBean product) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement insert = con.prepareStatement
					("INSERT INTO PRODUCTOPS VALUES(?,?,?,?)");
			
			insert.setString(1, product.getCode());
			insert.setString(2, product.getName());
			insert.setFloat(3, product.getPrice());
			insert.setInt(4, product.getQuantity());
			k = insert.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}
		return k;
	}
}