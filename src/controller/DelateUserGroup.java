package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserGroupDao;

@WebServlet("/DelateUserGroup")
public class DelateUserGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer group_id = Integer.parseInt(request.getParameter("id"));
		UserGroupDao.delete(group_id);
		System.out.println("Usunięto grupę o id:" + group_id);

		response.sendRedirect("panel");
	}
}
