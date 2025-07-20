package servlets;

import java.io.IOException;

import daos.CandidateDao;
import daos.CandidateDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteCan")
public class DeleteCandidate extends HttpServlet {

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

		int canId = Integer.parseInt(req.getParameter("candId"));

		try (CandidateDao canDao = new CandidateDaoImpl()) {
			if(canDao.deleteById(canId)!=0) {
				resp.sendRedirect("ResultServle");
			}
			

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
