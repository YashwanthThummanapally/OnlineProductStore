package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/viewcust")
public class ViewCustomerProfileServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("message", "Session Expired!");
			req.getRequestDispatcher("RegisterCustomer.jsp").forward(req, res);
		}else {
			req.getRequestDispatcher("ViewCustomerProfile.jsp").forward(req, res);
		}
	}
}