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

		HttpSession session = request.getSession();
		Integer user_id = (Integer) session.getAttribute("id");
		System.out.println(user_id);

		Integer id = (Integer) session.getAttribute("systemUserId");

		System.out.println("sendMessage: " + id);
		System.out.println("systemUsername: " + request.getSession().getAttribute("systemUsername"));
		System.out.println("systemUserEmail: " + request.getSession().getAttribute("systemUserEmail"));

		System.out.println("sendMessage: " + session.getAttribute("systemUserId"));
		System.out.println("systemUsername: " + request.getSession().getAttribute("systemUsername"));
		System.out.println("systemUserEmail: " + request.getSession().getAttribute("systemUserEmail"));
		/*
		 * Integer senderId = Integer.parseInt(user_id); User sender =
		 * UsersDao.loadById(senderId);
		 */
		/*
		 * System.out.println("senderId:" + senderIdString);
		 * System.out.println("senderId:" + senderIdString);
		 * 
		 * String targetUserIdString = request.getParameter("select"); Integer
		 * targetUserId = Integer.parseInt(targetUserIdString);
		 * 
		 * String message = request.getParameter("message"); String addedBy =
		 * sender.getName();
		 * 
		 * Message newMessage = new Message(targetUserId, message, addedBy);
		 * 
		 * boolean isAdded = MessageDao.saveToDb(newMessage); if (isAdded) {
		 * response.sendRedirect("mainUserView"); System.out.println("sukces"); } else {
		 * response.sendRedirect("mainUserView"); }
		 */

	}
}
