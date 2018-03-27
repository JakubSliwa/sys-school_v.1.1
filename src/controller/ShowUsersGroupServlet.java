package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsersDao;
import model.User;

@WebServlet("/show-users-group")
public class ShowUsersGroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String groupId = request.getParameter("id");
		Integer group_id = Integer.parseInt(groupId);
		List<User> user = UsersDao.loadAllByGroupId(group_id);
		request.setAttribute("users", user);

		getServletContext().getRequestDispatcher("/WEB-INF/users.jsp?id=" + group_id).forward(request, response);
	}

}
