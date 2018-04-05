package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsersDao;

@WebServlet("/DelateUser")
public class DelateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer user_id = Integer.parseInt(request.getParameter("id"));
		UsersDao.delete(user_id);
		System.out.println("Usunięto użytkownika o id:" + user_id);

		response.sendRedirect("panel");

	}
}
