package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsersDao;
import model.User;

@WebServlet("/RegisterNewUser")
public class RegisterNewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/registerNewUser.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String newName = request.getParameter("registerName");
		String newEmail = request.getParameter("registerEmail");
		String newPassword = request.getParameter("registerPassword");
		Integer newUserGroupId = 1;

		User newUser = new User(newName, newEmail, newPassword, newUserGroupId);
		UsersDao.saveToDB(newUser);

		response.sendRedirect("StartServlet");
	}

}
