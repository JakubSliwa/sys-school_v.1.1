package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		System.out.println(request.getParameter("loginEmail"));
		String userEmail = request.getParameter("loginEmail");

		User loadedUser = UsersDao.loadByEmail(userEmail);
		Integer user_id = loadedUser.getId();

		User loadedUserNew = UsersDao.loadById(user_id);
		request.setAttribute("loadedUser", loadedUserNew);

		getServletContext().getRequestDispatcher("/WEB-INF/userStartPage.jsp?=" + user_id).forward(request, response);
	}

}
