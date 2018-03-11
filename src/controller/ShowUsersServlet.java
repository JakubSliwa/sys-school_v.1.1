package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserGroupDao;
import dao.UsersDao;
import model.User;
import model.UserGroup;

/**
 * Servlet implementation class ShowUsersServlet
 */
@WebServlet("/ShowUsersServlet")
public class ShowUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer groupId = Integer.parseInt(request.getParameter("id"));
		List<User> user = UsersDao.loadAllByGroupId(groupId);
		request.setAttribute("users", user);

		getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
	}

	
}
