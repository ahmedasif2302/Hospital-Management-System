package com.royel.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.royel.dao.DBManager;

@WebServlet("/messageDelete")
public class MessageDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MessageDeleteController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/messageList.jsp");

		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int mid = Integer.parseInt(request.getParameter("mid"));
		String errorString = null;

		if (DBManager.deleteSelectedMessage(mid)) {
			response.sendRedirect(request.getContextPath() + ("/messageList"));
		} else {
			errorString = "Your requested id " + mid + " is not deleted !!";
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/error2.jsp");
			dispatcher.forward(request, response);
		}
	}

}
