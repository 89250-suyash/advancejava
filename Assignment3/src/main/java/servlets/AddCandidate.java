package servlets;

import java.io.IOException;
import java.sql.Date;

import daos.CandidateDao;
import daos.CandidateDaoImpl;
import daos.UserDao;
import daos.UserDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pojos.Candidate;
import pojos.User;

@WebServlet("/addCandidate")
public class AddCandidate extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(req, resp);
	}

	protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String name = req.getParameter("name");
		String party = req.getParameter("party");
		int votes = 0;

		Candidate c = new Candidate();
		c.setName(name);
		c.setParty(party);
		c.setVotes(votes);
		try (CandidateDao can = new CandidateDaoImpl()) {

			int cnt = can.save(c);

			if (cnt != 0) {

				resp.sendRedirect("ResultServle");
			} else {
				System.out.println("Error");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
