package servlets;

import java.io.IOException;
import java.sql.Date;

import daos.UserDao;
import daos.UserDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pojos.User;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(req, resp);
	}

	protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String firestName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		Date bdDate = Date.valueOf(req.getParameter("bDate"));
		boolean status = false;
		String role = "voter";

		try (UserDao userDao = new UserDaoImpl()) {
			User u = new User();

			u.setFirstName(firestName);
			u.setLastName(lastName);
			u.setEmail(email);
			u.setPasswd(password);
			u.setBirth(bdDate);
			u.setStatus(status);
			u.setRole(role);

			int cnt = userDao.save(u);

			if (cnt != 0) {
				
				resp.sendRedirect("index.html");
			} else {
				System.out.println("Error");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
