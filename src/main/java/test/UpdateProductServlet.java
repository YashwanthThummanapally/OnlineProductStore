package test;
import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/update")
public class UpdateProductServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("message", "Session Expired!");
			req.getRequestDispatcher("Message.jsp").forward(req, res);
		}else {
			ArrayList<ProductBean> products = (ArrayList<ProductBean>)hs.getAttribute("Products");
			String pcode = req.getParameter("code");
			
			Iterator<ProductBean> it = products.iterator();
			while(it.hasNext()) {
				ProductBean product = it.next();
				if(pcode.equals(product.getCode())) {
					product.setPrice(Float.parseFloat(req.getParameter("price")));
					product.setQuantity(Integer.parseInt(req.getParameter("qty")));
					
					int k = new UpdateProductDAO().update(product);
					if(k>0) {
						req.setAttribute("message", "Product Updated Successfully...");
					}else {
						req.setAttribute("message", "Cannot Update Product!");
					}
					req.getRequestDispatcher("UpdateProduct.jsp").forward(req, res);
					break;
				}
			}
		}
	}
}