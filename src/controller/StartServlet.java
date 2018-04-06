package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import dao.UsersDao;
import model.User;

@WebServlet("/StartServlet")
public class StartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/loginPage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String loginEmail = request.getParameter("loginEmail");
		String loginPassword = request.getParameter("loginPassword");

		System.out.println(loginEmail);
		System.out.println(loginPassword);

		User user = UsersDao.loadByEmail(loginEmail);
		String systemPassword = user.getPassword();
		Integer systemUserGroupId = user.getUserGroupId();

		System.out.println("-------");
		System.out.println(systemPassword);
		System.out.println(systemUserGroupId);

		if (BCrypt.checkpw(loginPassword, systemPassword) && systemUserGroupId == 1) {
			System.out.println("opcja 1");
			getServletContext().getRequestDispatcher("/mainUserView").forward(request, response);
		} else if (BCrypt.checkpw(loginPassword, systemPassword) && systemUserGroupId == 2) {
			System.out.println("opcja 2");
			getServletContext().getRequestDispatcher("/main").forward(request, response);
		} else {
			System.out.println("opcja 3");
			getServletContext().getRequestDispatcher("/WEB-INF/loginPage.jsp").forward(request, response);
		}

	}

}
