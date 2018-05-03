package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MessageDao;
import dao.UsersDao;
import model.Message;
import model.User;

@WebServlet("/SendMessage")
public class SendMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		System.out.println("---------------------");
		HttpSession session = request.getSession();
		Integer user_id = (Integer) session.getAttribute("systemUserId");
		System.out.println(user_id);
		
		User userSes = (User) session.getAttribute("sessionUser");
		session.setAttribute("systemUserId", userSes.getId());	
		System.out.println(session.getAttribute("systemUserId"));
		Integer userSes_id = userSes.getId();
		System.out.println(userSes_id);
		
		String senderEmail = (String) session.getAttribute("systemUserEmail");
		User sender = UsersDao.loadByEmail(senderEmail);
		Integer user_idTest = sender.getId();
		request.setAttribute("user_idTest", user_idTest);
		
		System.out.println(user_idTest);

		System.out.println(senderEmail);
		String targetUserIdString = request.getParameter("select");
		Integer targetUserId = Integer.parseInt(targetUserIdString);

		String message = request.getParameter("message");
		String addedBy = sender.getName();

		Message newMessage = new Message(targetUserId, addedBy, message);
		boolean isAdded = MessageDao.saveToDb(newMessage);

		if (isAdded == true) {
			String isSend = "yes";
			request.setAttribute("isSend", isSend);
			

			response.sendRedirect("mainUserView");

		} else {
			String isSend = "no";
			request.setAttribute("isSend", isSend);

			response.sendRedirect("/mainUserView");

		}

	}
}
