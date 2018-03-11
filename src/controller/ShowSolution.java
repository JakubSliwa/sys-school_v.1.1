package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SolutionDao;
import model.Solution;

/**
 * Servlet implementation class ShowSolution
 */
@WebServlet("/show-solution")
public class ShowSolution extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Solution solution = SolutionDao.loadById(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("solution", solution);

		getServletContext().getRequestDispatcher("/WEB-INF/showSolution.jsp").forward(request, response);

	}

}
