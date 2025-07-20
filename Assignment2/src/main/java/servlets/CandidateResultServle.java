package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import daos.CandidateDao;
import daos.CandidateDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
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
		out.println("<title>Candidates</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>candidate List</h1>");

		out.println("<table>");
		out.println("<thead>");
		out.println("<tr>");
		out.println("<th>Name</th>");
		out.println("<th>Party</th>");
		out.println("<th>Votes</th>");
		out.println("</tr>");

		for (Candidate c : candList) {

			out.println("<tr>");
			out.printf("<td>%s</td>", c.getName());
			out.printf("<td>%s</td>", c.getParty());
			out.printf("<td>%d</td>", c.getVotes());
//			out.println("<input type='butt");
			out.println("</tr>");

		}

		out.println("</thead>");
		out.println("</table>");

		out.println("<div>");
		out.println("<a href='AddCandidates.html'>addCandidate</a>");

		out.println("</div>");

		out.println("</body>");
		out.println("</html>");

//		<div>
//		<input type="submit" value="Sign In" /> <a href="register.html">Sign
//			Up</a>
//
//	</div>

	}

}

//<table>
//<tr>
//  <th>Company</th>
//  <th>Contact</th>
//  <th>Country</th>
//</tr>
//<tr>
//  <td>Alfreds Futterkiste</td>
//  <td>Maria Anders</td>
//  <td>Germany</td>
//</tr>
//<tr>
//  <td>Centro comercial Moctezuma</td>
//  <td>Francisco Chang</td>
//  <td>Mexico</td>
//</tr>
//</table>
