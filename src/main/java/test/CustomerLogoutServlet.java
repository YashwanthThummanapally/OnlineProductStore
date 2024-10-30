package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/custlogout")
public class CustomerLogoutServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("message", "Session Expired!");
			req.getRequestDispatcher("RegisterCustomer.jsp").forward(req, res);
		}else {
			hs.removeAttribute("cbean");
			hs.removeAttribute("productlist");
			hs.invalidate();
			req.setAttribute("message", "Logged out successfully...");
			req.getRequestDispatcher("CustomerLogout.jsp").forward(req, res);
		}
	}
}