package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
		User user = (User) request.getSession().getAttribute("user");

		String senderEmail = (String) session.getAttribute("systemUserEmail");
		User sender = UsersDao.loadByEmail(senderEmail);

		String targetUserIdString = request.getParameter("select");
		Integer targetUserId = Integer.parseInt(targetUserIdString);

		String message = request.getParameter("message");
		String addedBy = sender.getName();

		Message newMessage = new Message(targetUserId, addedBy, message);
		boolean isAdded = MessageDao.saveToDb(newMessage);

		if (isAdded == true) {
			String isSend = "yes";
			request.setAttribute("isSend", isSend);

			getServletContext().getRequestDispatcher("/mainUserView").forward(request, response);

		} else {
			String isSend = "no";
			request.setAttribute("isSend", isSend);

			response.sendRedirect("/mainUserView");

		}

	}
}
