package controller;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsersDao;
import model.User;

@WebServlet("/addNewUser")
public class AddNewUser extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/adminAddNewUser.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String newName = request.getParameter("newName");
		String newEmail = request.getParameter("newEmail");
		String newPassword = request.getParameter("newPassword");
		Integer newUserGroupId = Integer.parseInt(request.getParameter("newUserGroupId"));

		User newUser = new User(newName, newEmail, newPassword, newUserGroupId);
		UsersDao.saveToDB(newUser);

		response.sendRedirect("panel");
	}

}
