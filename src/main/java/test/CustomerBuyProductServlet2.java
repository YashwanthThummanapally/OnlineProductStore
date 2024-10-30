package test;
import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/buyprod2")
public class CustomerBuyProductServlet2 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("message", "Session Expired!");
			req.getRequestDispatcher("RegisterCustomer.jsp").forward(req, res);
		}else {
			ArrayList<ProductBean> products = (ArrayList<ProductBean>)hs.getAttribute("productlist");
			String code = req.getParameter("pcode");
			Iterator<ProductBean> it = products.iterator();
			
			while(it.hasNext()) {
				ProductBean product = it.next();
				if(code.equals(product.getCode())) {
					int reqQty = Integer.parseInt(req.getParameter("reqqty"));
					if(reqQty<=product.getQuantity()) {
						req.setAttribute("product", product);
						req.getRequestDispatcher("CustomerBuyProduct2.jsp").forward(req, res);
					}else {
						req.setAttribute("product", product);
						req.getRequestDispatcher("CustomerBuyProduct.jsp").forward(req, res);
					}
				}
			}
		}
	}
}