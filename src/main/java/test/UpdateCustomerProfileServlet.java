package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/updatecust")
public class UpdateCustomerProfileServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("message", "Session Expired!");
			req.getRequestDispatcher("RegisterCustomer.jsp").forward(req, res);
		}else {
			CustomerBean cust = (CustomerBean)hs.getAttribute("cbean");
			cust.setAddress(req.getParameter("addr"));
			cust.setMailId(req.getParameter("mail"));
			cust.setPhoneNumber(Long.parseLong(req.getParameter("phno")));
			
			int k = new UpdateCustomerProfileDAO().update(cust);
			if(k>0) {
				req.setAttribute("message", "Profile Updated Successfully...");
			}else {
				req.setAttribute("message", "Failed to update!");
			}
			req.getRequestDispatcher("UpdateCustomerProfile.jsp").forward(req, res);
		}
	}
}