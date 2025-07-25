package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(req, resp);
	}

	protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Login</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>LogOut</h2>");

		String uname = "";

		Cookie[] crr = req.getCookies();

		if (crr != null) {
			for (Cookie c : crr) {
				if (c.getName().equals("userName"))
					uname = c.getValue();
			}
		}
		out.printf("<h3>Thank You , %s</h3><br>", uname);

		Cookie c = new Cookie("userName", "");
		c.setMaxAge(0);

		resp.addCookie(c);

		out.println("<a href='index.html'>Login Agin</a>");

		out.println("</body>");

		out.println("</html>");
	}

}
