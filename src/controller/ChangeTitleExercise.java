package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ExerciseDao;
import model.Exercise;

@WebServlet("/ChangeTitleExercise")
public class ChangeTitleExercise extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer ex_id = Integer.parseInt(request.getParameter("id"));
		Exercise exercise = ExerciseDao.loadById(ex_id);

		request.setAttribute("loadedExercise", exercise);

		getServletContext().getRequestDispatcher("/WEB-INF/adminChangeTitleExercise.jsp?id=" + ex_id).forward(request,
				response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer ex_id = Integer.parseInt(request.getParameter("id"));
		String newTitle = request.getParameter("newTitle");

		ExerciseDao.updateTitle(ex_id, newTitle);

		response.sendRedirect("panel");
	}

}
