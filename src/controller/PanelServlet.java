package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ExerciseDao;
import dao.SolutionDao;
import dao.UsersDao;
import model.Exercise;
import model.Solution;
import model.User;

@WebServlet("/panel")
public class PanelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<User> user = UsersDao.loadAll();
		List<Solution> solution = SolutionDao.loadAll();
		List<Exercise> exercise = ExerciseDao.loadAll();

		request.setAttribute("user", user);
		request.setAttribute("solution", solution);
		request.setAttribute("exercise", exercise);

		getServletContext().getRequestDispatcher("/WEB-INF/panelAdmin.jsp").forward(request, response);
	}

}
