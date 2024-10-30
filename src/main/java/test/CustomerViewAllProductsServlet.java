package test;
import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/viewprod")
public class CustomerViewAllProductsServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("message", "Session Expired!");
			req.getRequestDispatcher("RegisterCustomer.jsp").forward(req, res);
		}else {
			ArrayList<ProductBean> products = new CustomerViewAllProductsDAO().retrieveAllProducts();
			hs.setAttribute("productlist", products);
			req.getRequestDispatcher("CustomerViewAllProducts.jsp").forward(req, res);
		}
	}
}