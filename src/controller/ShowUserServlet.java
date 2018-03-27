package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SolutionDao;
import dao.UsersDao;
import model.Solution;
import model.User;

@WebServlet("/show-user")
public class ShowUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userId = request.getParameter("id");
		Integer user_Id = Integer.parseInt(userId);
		User user = UsersDao.loadById(user_Id);
		List<Solution> solutionsByUserId = SolutionDao.loadSolutionByUserId(user_Id);
		request.setAttribute("user", user);
		request.setAttribute("solutionByUserId", solutionsByUserId);

		getServletContext().getRequestDispatcher("/WEB-INF/userSolutions.jsp").forward(request, response);
	}

}
