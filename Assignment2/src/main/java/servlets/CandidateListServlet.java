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

@WebServlet("/candidatelist")

public class CandidateListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(req, resp);
	}

	protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Candidate> canList = new ArrayList();

		try (CandidateDao cand = new CandidateDaoImpl()) {
			canList = cand.findAll();

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
		out.println("<form method='post' action='vote'>");
		for (Candidate candidate : canList) {
			out.printf("<input type = 'radio' name='candidate' value='%d'/> %s (%s)<br>\n", candidate.getId(),
					candidate.getName(), candidate.getParty());

		}
		
		out.println("<input type='submit' value='Vote'>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");

	}
}
