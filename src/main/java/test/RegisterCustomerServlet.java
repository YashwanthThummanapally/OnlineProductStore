package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/regcust")
public class RegisterCustomerServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		CustomerBean cust = new CustomerBean();
		cust.setUsername(req.getParameter("uname"));
		cust.setPassword(req.getParameter("pwd"));
		cust.setFirstName(req.getParameter("fname"));
		cust.setLastName(req.getParameter("lname"));
		cust.setAddress(req.getParameter("addr"));
		cust.setMailId(req.getParameter("mail"));
		cust.setPhoneNumber(Long.parseLong(req.getParameter("phno")));
		
		int k = new RegisterCustomerDAO().registerCustomer(cust);
		if(k>0) {
			req.setAttribute("message", "Customer Registered Successfully...");
		}else {
			req.setAttribute("message","Customer Registration Failed!");
		}
		req.getRequestDispatcher("RegisterCustomer.jsp").forward(req, res);
	}
}