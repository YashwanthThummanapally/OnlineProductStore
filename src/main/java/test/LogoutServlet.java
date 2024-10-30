package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("message", "Session Expired!");
			req.getRequestDispatcher("Message.jsp").forward(req, res);
		}else {
			hs.invalidate();
			req.setAttribute("message", "Admin Loggedout Successfully...");
			req.getRequestDispatcher("Logout.jsp").forward(req, res);
		}
	}
}