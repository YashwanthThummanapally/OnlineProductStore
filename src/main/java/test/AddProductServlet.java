package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/add")
public class AddProductServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false); // Accessing existing Session
		if(hs==null) {
			req.setAttribute("message", "Session Expired!");
			req.getRequestDispatcher("Message.jsp").forward(req, res);
		}else {
			ProductBean product = new ProductBean();
			product.setCode(req.getParameter("code"));
			product.setName(req.getParameter("name"));
			product.setPrice(Float.parseFloat(req.getParameter("price")));
			product.setQuantity(Integer.parseInt(req.getParameter("qty")));
			
			int k = new AddProductDAO().insertProduct(product);
			if(k>0) {
				req.setAttribute("message", "Product Added Successfully...");
				req.getRequestDispatcher("AddProduct.jsp").forward(req, res);
			}else {
				req.setAttribute("message", "Cannot Add Product!");
				req.getRequestDispatcher("AddProduct.jsp").forward(req, res);
			}
		}
	}
}