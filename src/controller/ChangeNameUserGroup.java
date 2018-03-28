package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserGroupDao;
import model.UserGroup;

@WebServlet("/ChangeNameUserGroup")
public class ChangeNameUserGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer group_id = Integer.parseInt(request.getParameter("id"));
		UserGroup userGroup = UserGroupDao.loadById(group_id);

		request.setAttribute("userGroup", userGroup);

		getServletContext().getRequestDispatcher("/WEB-INF/adminChangeNameUserGroup.jsp?id=" + group_id)
				.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer group_id = Integer.parseInt(request.getParameter("id"));
		String newName = request.getParameter("newName");
		UserGroupDao.updateAllUserGroupParameter(group_id, newName);

		response.sendRedirect("panel");

		/*
		 * getServletContext().getRequestDispatcher("/WEB-INF/panelAdmin.jsp").forward(
		 * request, response);
		 */

	}

}
