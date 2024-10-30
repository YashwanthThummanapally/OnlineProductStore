package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/logincust")
public class LoginCustomerServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		CustomerBean cust = new LoginCustomerDAO().login(req.getParameter("uname"), req.getParameter("pwd"));
		if(cust==null) {
			req.setAttribute("message", "Invalid Login Process!");
			req.getRequestDispatcher("RegisterCustomer.jsp").forward(req, res);
		}else {
			HttpSession hs = req.getSession();
			hs.setAttribute("cbean", cust);
			req.getRequestDispatcher("LoginCustomer.jsp").forward(req, res);
		}
	}
}