package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ExerciseDao;
import dao.MessageDao;
import dao.UsersDao;
import model.Exercise;
import model.Message;
import model.User;

@WebServlet("/mainUserView")
public class MainUserView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Integer user_id = (Integer) session.getAttribute("systemUserId");
		
		User userSes = (User) session.getAttribute("sessionUser");
		session.setAttribute("systemUserId", userSes.getId());	
		System.out.println(session.getAttribute("systemUserId"));
		Integer userSes_id = userSes.getId();
		System.out.println(userSes_id);
		
		List<User> user = UsersDao.loadAll();
		request.setAttribute("user", user);

		List<Exercise> list = ExerciseDao.loadAll();
		System.out.println("rozmiar: " + list.size());
		request.setAttribute("exercise", list);

		System.out.println("User id: " + session.getAttribute("systemUserId"));
		System.out.println("User Groudp id: " + session.getAttribute("systemUserGroupId"));

		String isSend = (String) request.getAttribute("isSend");
		System.out.println("is send: " + isSend);
		
		List<Message> messages = MessageDao.loadById(userSes_id);
		System.out.println("rozmiar: " + messages.size());
		
		
		request.setAttribute("recivedMessages", messages);
		
	
	
		
		request.setAttribute("recivedMessagesSize", messages);
		getServletContext().getRequestDispatcher("/WEB-INF/userStartPage.jsp?=" + user_id).forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Integer user_id = (Integer) session.getAttribute("systemUserId");

		List<User> user = UsersDao.loadAll();
		request.setAttribute("user", user);

		List<Exercise> list = ExerciseDao.loadAll();
		System.out.println("rozmiar: " + list.size());
		request.setAttribute("exercise", list);

		System.out.println("User id: " + session.getAttribute("systemUserId"));
		System.out.println("User Groudp id: " + session.getAttribute("systemUserGroupId"));

		String isSend = (String) request.getAttribute("isSend");
		System.out.println("is send: " + isSend);
		
		List<Message> messages = MessageDao.loadById(user_id);
		System.out.println("rozmiar: " + messages.size());
		
		
		request.setAttribute("recivedMessages", messages);
		
	
	
		
		request.setAttribute("recivedMessagesSize", messages);
		getServletContext().getRequestDispatcher("/WEB-INF/userStartPage.jsp?=" + user_id).forward(request, response);

	}

}
