package com.royel.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.royel.bean.MessageBean;
import com.royel.dao.DBManager;

@WebServlet("/contact")
public class MessageRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MessageRegistrationController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	       RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/contact.jsp");        
	       dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String message = request.getParameter("message");
		
		MessageBean userMessage = new MessageBean(name, email, message);
				
		String errorString = null;

		if (name == "" || email == "" || message == "") {
			errorString = "Fill up the form correctly :)";
			request.setAttribute("errorString", errorString);

			RequestDispatcher dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/contact.jsp");

			dispatcher.forward(request, response);
		}
		
		if (DBManager.registerMessageIntoDB(userMessage)) {

			errorString = "Your message has been sent :)";
			request.setAttribute("errorString", errorString);

			RequestDispatcher dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/contact.jsp");

			dispatcher.forward(request, response);

		} else {

			errorString = "Error Occured !! Your message doesn't send !!";
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/error2.jsp");
			dispatcher.forward(request, response);

		}
		
	}

}
