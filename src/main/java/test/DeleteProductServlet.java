package test;
import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/delete")
public class DeleteProductServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("message", "Session Expired!");
			req.getRequestDispatcher("Message.jsp").forward(req, res);
		}else {
			String pcode = req.getParameter("pcode");
			ArrayList<ProductBean> products = (ArrayList<ProductBean>)hs.getAttribute("Products");
			Iterator<ProductBean> it = products.iterator();
			
			while(it.hasNext()) {
				ProductBean product = it.next();
				if(pcode.equals(product.getCode())) {
					boolean remove = products.remove(product);
					int k = new DeleteProductDAO().removeProduct(product);
					if(k>0 && remove) {
						req.setAttribute("message", "Product Deleted Successfully...");
					}else {
						req.setAttribute("message", "Cannot delete product!");
					}
					req.getRequestDispatcher("DeleteProduct.jsp").forward(req, res);
				}
			}
		}
	}
}