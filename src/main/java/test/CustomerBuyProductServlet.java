package test;
import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/buyprod")
public class CustomerBuyProductServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("message", "Session Expired!");
			req.getRequestDispatcher("RegisterCustomer.jsp").forward(req, res);
		}else {
			String pcode = req.getParameter("pcode");
			ArrayList<ProductBean> products = (ArrayList<ProductBean>)hs.getAttribute("productlist");
			Iterator<ProductBean> itr = products.iterator();
			
			while(itr.hasNext()) {
				ProductBean product = itr.next();
				if(pcode.equals(product.getCode())) {
					req.setAttribute("product", product);
					req.getRequestDispatcher("CustomerBuyProduct.jsp").forward(req, res);
				}
			}
		}
	}
}