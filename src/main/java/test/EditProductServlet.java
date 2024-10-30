package test;
import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/edit")
public class EditProductServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("message", "Session Expired!");
			req.getRequestDispatcher("Message.jsp").forward(req, res);
		}else {
			ArrayList<ProductBean> products = (ArrayList<ProductBean>)hs.getAttribute("Products");
			String pcode = req.getParameter("pcode");
			
			Iterator<ProductBean> it = products.iterator();
			while(it.hasNext()) {
				ProductBean product = it.next();
				if(pcode.equals(product.getCode())) {
					req.setAttribute("Product", product);
					req.getRequestDispatcher("EditProduct.jsp").forward(req, res);
					break;
				}
			}
		}
	}
}