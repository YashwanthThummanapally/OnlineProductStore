package test;
import java.sql.*;
import java.util.*;
public class CustomerViewAllProductsDAO {
	private ArrayList<ProductBean> products = new ArrayList<>();
	
	public ArrayList<ProductBean> retrieveAllProducts(){
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement select = con.prepareStatement
					("SELECT * FROM PRODUCTOPS");
			
			ResultSet rs = select.executeQuery();
			while(rs.next()) {
				ProductBean product = new ProductBean();
				product.setCode(rs.getString(1));
				product.setName(rs.getString(2));
				product.setPrice(rs.getFloat(3));
				product.setQuantity(rs.getInt(4));
				
				products.add(product);
			}
		}catch(Exception e) {e.printStackTrace();}
		return products;
	}
}