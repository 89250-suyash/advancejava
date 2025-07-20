package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import daos.CandidateDao;
import daos.CandidateDaoImpl;
import daos.UserDao;
import daos.UserDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pojos.User;

@WebServlet("/vote")
public class VoteServlet extends HttpServlet {
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

		HttpSession session = req.getSession();

		User user = (User) session.getAttribute("user");

		if (user.isStatus() == true) {
			resp.setContentType("text/html");

			PrintWriter out = resp.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Vote</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h2>Alrady Voted</h2>");
			out.println("<a href='logout'>SignOut</a>");

			out.println("</body>");

			out.println("</html>");
		} else {
			user.setStatus(true);
			try (UserDao ud = new UserDaoImpl()) {

				int cnt = ud.update(user);
				if (cnt != 0)
					System.out.println("Successful");

			} catch (Exception e) {
				e.printStackTrace();
			}

			int canId = Integer.parseInt(req.getParameter("candidate"));

			try (CandidateDao canDao = new CandidateDaoImpl()) {

				int cnt = canDao.incrVote(canId);

				if (cnt != 0)
					System.out.println("successful");

			} catch (Exception e) {
				e.printStackTrace();
			}
			resp.setContentType("text/html");

			PrintWriter out = resp.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>congrats</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h2>congratulation</h2>");
			out.println("Your Vote Registered Successfully");
			out.println("<a href='logout'>SignOut</a>");

			out.println("</body>");

			out.println("</html>");

		}
	}

}
