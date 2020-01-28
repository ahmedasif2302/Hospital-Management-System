package com.royel.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.royel.bean.MessageBean;
import com.royel.dao.DBManager;


@WebServlet("/messageList")
public class MessageListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MessageListController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<MessageBean> allMessage = DBManager.selectAllMessage();

		String errorString = null;

		if (allMessage.isEmpty()) {
			errorString = "No message found !!";
			request.setAttribute("errorString", errorString);
		} else {
			errorString = "Total " + allMessage.size() + " message found ";
			request.setAttribute("allMessage", allMessage);
			request.setAttribute("errorString", errorString);
		}

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/messageList.jsp");

		dispatcher.forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
