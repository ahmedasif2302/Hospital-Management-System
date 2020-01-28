package com.royel.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.royel.bean.AppointmentBean;
import com.royel.dao.DBManager;


@WebServlet("/appointmentVerification")
public class AppointmentVerificationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AppointmentVerificationController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String code = request.getParameter("code");
		
		HttpSession session = request.getSession();
		
		String errorString = null;
		
		String randomCodeFromSession = (String) session.getAttribute("securityCode");
		AppointmentBean appointment = (AppointmentBean) session.getAttribute("userAppointment");
		
		System.out.println("receive data from session");
		
		if (code.equals(randomCodeFromSession)) {
			
			System.out.println("code is verified. ");
			
			if (DBManager.createAppointment(appointment)) {
				
				errorString = "Your appointment is confirmed..";
				System.out.println(errorString);
				
				request.setAttribute("errorString", errorString);
				
				RequestDispatcher dispatcher = this.getServletContext()
						.getRequestDispatcher("/WEB-INF/views/appointmentOnline.jsp");				
				dispatcher.forward(request, response);
			}else{
				errorString = "Your appointment is not confirmed..";
				System.out.println(errorString);
				
				request.setAttribute("errorString", errorString);
				
				RequestDispatcher dispatcher = this.getServletContext()
						.getRequestDispatcher("/WEB-INF/views/error2.jsp");				
				dispatcher.forward(request, response);
			}
			
		}else {
			errorString ="Your account is not varified.. Try again..";
			System.out.println(errorString);
			request.setAttribute("errorString", errorString);
			
			RequestDispatcher dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/appointmentOnline.jsp");				
			dispatcher.forward(request, response);
			
		}
		
	}

}
