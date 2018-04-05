package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsersDao;
import model.User;

@WebServlet("/ChangeUserGroup")
public class ChangeUserGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer user_id = Integer.parseInt(request.getParameter("id"));
		User user = UsersDao.loadById(user_id);

		request.setAttribute("loadedUser", user);

		getServletContext().getRequestDispatcher("/WEB-INF/adminChangeUserGroup.jsp?id=" + user_id).forward(request,
				response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer user_id = Integer.parseInt(request.getParameter("id"));
		String newUserGroup = request.getParameter("newUserGroup");
		UsersDao.updateUserGroup(user_id, newUserGroup);

		response.sendRedirect("panel");
	}
}
