package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import daos.CandidateDao;
import daos.CandidateDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pojos.Candidate;

@WebServlet("/editCand")
public class EditCandServlet extends HttpServlet {
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

//		Candidate cand = new Candidate();
//		cand.setId( Integer.parseInt(req.getParameter("candId")));
		
//		cand.setName(req.getParameter("name"));
//		cand.setParty(req.getParameter("party"));
		
		
		
		
//
//		try (CandidateDao canDao = new CandidateDaoImpl()) {
//				if(canDao.update(cand)!=0)
//					
//				else 
//					System.out.println("Erorr while edit");
//					
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		Candidate cand2 = new Candidate();
		int id = Integer.parseInt(req.getParameter("candId"));
		
		try(CandidateDao canDao = new CandidateDaoImpl()){
			 cand2 = canDao.findById(id);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		

		
		resp.setContentType("text/html");
	    PrintWriter out = resp.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("    <meta charset=\"UTF-8\">");
		out.println("    <title>Edit Candidate</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("    <form action=\"ResultServle\" method=\"POST\">");
		out.println("        <div>");
		out.printf("            ID: <input type=\"text\" name=\"id\" value='%d' readonly><br>",cand2.getId());
		out.printf("            Name: <input type=\"text\" name=\"name\" value='%s'><br>",cand2.getName());
		out.printf("            Party: <input type=\"text\" name=\"party\" value='%s'><br>",cand2.getParty());
		out.printf("            Vote: <input type=\"text\" name=\"votes\" value='%d' readonly><br>",cand2.getVotes());
		out.println("        </div>");
		out.println("        <input type=\"submit\" value=\"Edit\">");
		out.println("    </form>");
		out.println("</body>");
		out.println("</html>");
		
		
	}
}
