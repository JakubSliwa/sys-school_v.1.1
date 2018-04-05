package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ExerciseDao;
import model.Exercise;

@WebServlet("/ChangeDescriptionExercise")
public class ChangeDescriptionExercise extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer ex_id = Integer.parseInt(request.getParameter("id"));
		Exercise exercise = ExerciseDao.loadById(ex_id);

		request.setAttribute("loadedExercise", exercise);

		getServletContext().getRequestDispatcher("/WEB-INF/adminChangeDescriptionExercise.jsp?id=" + ex_id)
				.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer ex_id = Integer.parseInt(request.getParameter("id"));
		String newDescription = request.getParameter("newDescription");

		ExerciseDao.updateDescription(ex_id, newDescription);

		response.sendRedirect("panel");
	}

}
