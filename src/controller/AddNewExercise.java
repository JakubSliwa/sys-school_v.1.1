package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ExerciseDao;
import model.Exercise;

@WebServlet("/AddNewExercise")
public class AddNewExercise extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/adminAddNewExercise.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String newTitle = request.getParameter("newTitle");
		String newDescription = request.getParameter("newDescription");

		Exercise exercise = new Exercise(newTitle, newDescription);
		ExerciseDao.saveToDB(exercise);

		response.sendRedirect("panel");
	}

}
