package com.sunbeam.pages;

import java.io.IOException;
import java.time.LocalDate;

import com.sunbeam.entities.User;
import com.sunbeam.service.UserService;
import com.sunbeam.service.UserServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontControllerServlet
 */
@WebServlet(value = "/", loadOnStartup = 1)
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;//java bean (B.L layer)

	/**
	 * @see Servlet#init()
	 */
	public void init() throws ServletException {
		
			// 1. create service layer  instance (create dependency)
			userService=new UserServiceImpl();
			System.out.println("init successful !");		
	}

	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// dev steps
			// 1. get request path
			// URL http://host:port/ctx/
			String path = request.getServletPath();//rets url-pattern
			String viewName = null;
			String prefix = "/WEB-INF/views/";
			String suffix = ".jsp";
			switch (path) {
			case "/": // render user list
				// add results (user list) - under request scope
				request.setAttribute("user_list", userService.listUsers());
				viewName = "list";
				break;
			case "/delete":
				System.out.println(deleteUserDetailsById(request));
				// redirect the client in the next request
				response.sendRedirect("./");
				return;
			case "/add":
				// show user signup form
				viewName = "signup";
				break;
			// Request URL -> http://host:port/ctx_path/process_add
			case "/process_add":
				System.out.println(addNewUser(request));
				// redirect client to the root ctx path (./) in the next request
				response.sendRedirect("./");
				return;
			case "/update":
				showUpdateForm(request);
				// forward the clnt -
				viewName = "update_form";
				break;
			case "/process_update":
				System.out.println(updateUser(request));
				//redirect
				response.sendRedirect("./");
				return;

			}
			if (viewName != null) {
				RequestDispatcher rd = 
						request.getRequestDispatcher(prefix + viewName + suffix);// AVN -
				// /WEB-INF/views/viewName.jsp
				rd.forward(request, response);
				System.out.println("control comes back after forward");
			}
		} catch (Exception e) {
			throw new ServletException("err in do-get of " + getClass(), e);
		}
	}

	private String updateUser(HttpServletRequest request)  {
		// 1. get req params -> parse
		Long userId = Long.parseLong(request.getParameter("id"));
		String password = request.getParameter("pass");
		LocalDate newDob = LocalDate.parse(request.getParameter("dob"));
		// invoke service method		
		return	userService.updateUserDetails(userId, password, newDob);
	}

	private void showUpdateForm(HttpServletRequest request)  {
		// 1. get id - from query string param
		Long userId = Long.parseLong(request.getParameter("id"));
		// 2. controller -> dao
		User userDetails = userService.getUserDetails(userId);
		// 3. store user details under request scope
		request.setAttribute("user_details", userDetails);
	}

	// override doPost - form processing
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// simply invoke doGet -> to delegate the processing
		doGet(req, resp);
	}

	private String addNewUser(HttpServletRequest request)  {
		// 1. get req params -> parse 
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String pwd = request.getParameter("pass");
		LocalDate dob = LocalDate.parse(request.getParameter("dob"));
		// create transient entity
		User user = new User(firstName, lastName, email, pwd, dob);
		return userService.addUser(user);		
	}

	private String deleteUserDetailsById(HttpServletRequest request)  {
		// parsing request param - user id
		Long userId = Long.parseLong(request.getParameter("id"));
		// invoke service layer method method
		return userService.deleteUser(userId);
	}
}
