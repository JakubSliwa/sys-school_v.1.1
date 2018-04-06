package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ExerciseDao;

@WebServlet("/DeleteExercise")
public class DeleteExercise extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer ex_id = Integer.parseInt(request.getParameter("id"));
		ExerciseDao.delete(ex_id);
		System.out.println("Usunięto zadanie o id:" + ex_id);

		response.sendRedirect("panel");
	}

}
