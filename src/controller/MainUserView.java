package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsersDao;
import model.User;

@WebServlet("/mainUserView")
public class MainUserView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("MainUserView: " + request.getSession().getAttribute("systemUserId"));
		System.out.println("MainUserView: " + request.getSession().getAttribute("systemUsername"));
		System.out.println("MainUserView: " + request.getSession().getAttribute("systemUserEmail"));
		List<User> user = UsersDao.loadAll();
		request.setAttribute("user", user);

		HttpSession session = request.getSession();
		Integer user_id = (Integer) session.getAttribute("systemUserId");

		getServletContext().getRequestDispatcher("/WEB-INF/userStartPage.jsp?=" + user_id).forward(request, response);
	}

}
