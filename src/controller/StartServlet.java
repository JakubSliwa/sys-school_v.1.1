package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		HttpSession session = request.getSession();

		String loginEmail = request.getParameter("loginEmail");
		String loginPassword = request.getParameter("loginPassword");
		User user = UsersDao.loadByEmail(loginEmail);
		
		session.setAttribute("sessionUser", user);

		String systemPassword = user.getPassword();
		Integer systemUserGroupId = user.getUserGroupId();
	
		session.setAttribute("systemUserId", user.getId());	
		request.setAttribute("loginEmail", loginEmail);

		if (BCrypt.checkpw(loginPassword, systemPassword) && systemUserGroupId == 1) {
			session.setAttribute("systemUsername", user.getName());
			session.setAttribute("systemUserEmail", user.getEmail());
			session.setAttribute("systemUserGroupId", user.getUserGroupId());
			session.setAttribute("systemUserId", user.getId());	
			System.out.println("User id: " + session.getAttribute("systemUserId") );
			System.out.println("User Groudp id: " + session.getAttribute("systemUserGroupId") );
			getServletContext().getRequestDispatcher("/mainUserView").forward(request, response);
		} else if (BCrypt.checkpw(loginPassword, systemPassword) && systemUserGroupId == 2) {
			session.setAttribute("systemUsername", user.getName());
			session.setAttribute("systemUserEmail", user.getEmail());
			session.setAttribute("systemUserGroupId", user.getUserGroupId());
			session.setAttribute("systemUserId", user.getId());
			getServletContext().getRequestDispatcher("/main").forward(request, response);
		} else {

			getServletContext().getRequestDispatcher("/WEB-INF/loginPage.jsp").forward(request, response);
		}

	}

}
