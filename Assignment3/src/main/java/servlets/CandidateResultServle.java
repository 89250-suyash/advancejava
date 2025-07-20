package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.CookieStore;
import java.util.ArrayList;
import java.util.List;

import daos.CandidateDao;
import daos.CandidateDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pojos.Candidate;

@WebServlet("/ResultServle")
public class CandidateResultServle extends HttpServlet {

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

		List<Candidate> candList = new ArrayList();

		try (CandidateDao cand = new CandidateDaoImpl()) {

			candList = cand.findAll();

		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Result </title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>candidate Result List</h1>");

		String userName = "";
		Cookie[] crr = req.getCookies();

		if (crr != null) {
			for (Cookie c : crr) {
				if (c.getName().equals("userName"))
					userName = c.getValue();
			}
		}

		out.printf("<h3>Hello , %s</h3>", userName);

		out.println("<hr>");
		out.println("<table border='1'>");
		out.println("<thead>");
		out.println("<tr>");
		out.println("<th>ID</th>");
		out.println("<th>Name</th>");
		out.println("<th>Party</th>");
		out.println("<th>Votes</th>");
		out.println("<th>Action</th>");
		out.println("</tr>");

		for (Candidate c : candList) {

			out.println("<tr>");
			out.printf("<td>%d</td>", c.getId());
			out.printf("<td>%s</td>", c.getName());
			out.printf("<td>%s</td>", c.getParty());
			out.printf("<td>%d</td>", c.getVotes());
			out.println("<td>");
			out.printf("<a href='deleteCan?candId=%d'><img src='images/delete.png' alt='Delete' height='21px' ></a>",
					c.getId());
			out.printf("<a href='editCand?candId=%d'><img src='images/edit.png' alt='Edi' height='21px' ></a>",
					c.getId());
			out.println("</td>");

			out.println("</tr>");

		}

		out.println("</thead>");
		out.println("</table>");

		out.println("<div>");
		out.println("<a href='announcment.html'>Announcment</a>");
		out.println("<a href='AddCandidates.html'>addCandidate</a>");
		out.println("<a href='logout'>SignOut</a>");

		out.println("</div>");

		out.println("</body>");
		out.println("</html>");

	}

}
