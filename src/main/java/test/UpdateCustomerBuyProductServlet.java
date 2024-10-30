package test;
import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/updateprod")
public class UpdateCustomerBuyProductServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("message", "Session Expired!");
			req.getRequestDispatcher("RegisterCustomer.jsp").forward(req, res);
		}else {
			String pcode = req.getParameter("pcode");
			int reqQty = Integer.parseInt(req.getParameter("reqqty"));
			ArrayList<ProductBean> products = (ArrayList<ProductBean>)hs.getAttribute("productlist");
			Iterator<ProductBean> it = products.iterator();
			
			while(it.hasNext()) {
				ProductBean product = it.next();
				if(pcode.equals(product.getCode())) {
					product.setQuantity(product.getQuantity()-reqQty);
					int k = new UpdateCustomerBuyProductDAO().update(product);
					if(k>0) {
						req.setAttribute("message", "Product Payment Successful...");
					}else {
						req.setAttribute("message", "Product Payment Failed!");
					}
					req.getRequestDispatcher("UpdateCustomerBuyProduct.jsp").forward(req, res);
				}
			}
		}
	}
}