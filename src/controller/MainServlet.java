package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SolutionDao;
import model.Solution;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String limitString = getServletContext().getInitParameter("number-solution");
		Integer limit = Integer.valueOf(limitString);

		List<Solution> list = SolutionDao.loadAll(limit);
		System.out.println("rozmiar: " + list.size());
		request.setAttribute("solutions", list);
		getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String limitString = getServletContext().getInitParameter("number-solution");
		Integer limit = Integer.valueOf(limitString);

		List<Solution> list = SolutionDao.loadAll(limit);
		System.out.println("rozmiar: " + list.size());
		request.setAttribute("solutions", list);
		getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);

	}
}
