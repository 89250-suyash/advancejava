package servlets;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

import daos.UserDao;
import daos.UserDaoImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pojos.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(req, resp);
	}

	protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		String role = "voter";

		try (UserDao userDao = new UserDaoImpl()) {

			User dbUser = userDao.findByEmail(email);

			if (dbUser != null && dbUser.getPasswd().equals(pass)) {
				System.out.println("Login Successfull");

				// create cookies to show user name

				String userName = dbUser.getFirstName() + dbUser.getLastName();
				Cookie c = new Cookie("userName", userName);
				c.setMaxAge(3600);
				resp.addCookie(c);

				// store user in session

				HttpSession session = req.getSession();
				session.setAttribute("user", dbUser);

				if (dbUser.getRole().equals(role)) {
					resp.sendRedirect("candidatelist");
				} else {
					resp.sendRedirect("ResultServle");

//					RequestDispatcher rd = req.getRequestDispatcher("ResultServle");
//					rd.forward(req, resp);

				}
			} else {
				resp.setContentType("text/html");

				PrintWriter out = resp.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Login</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h2>Login Failed</h2>");
				out.println("<a href='index.html'>Login Agin</a>");

				out.println("</body>");

				out.println("</html>");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
