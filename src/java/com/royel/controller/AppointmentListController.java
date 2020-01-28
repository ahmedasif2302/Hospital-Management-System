package com.royel.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.royel.bean.AppointmentBean;
import com.royel.dao.DBManager;
import com.royel.utility.SessionCookiesUtility;

@WebServlet("/appointmentList")
public class AppointmentListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AppointmentListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		if (SessionCookiesUtility.loginedUserSessionIsInvalid(session)) {
			response.sendRedirect(request.getContextPath() + "/AdminLogin");
			return;
		}
		
		List<AppointmentBean> allAppointment = DBManager.selectAllAppointments();
		
		String errorString = null;
		
		if (allAppointment.isEmpty()) {
			errorString = "No Current Patients data found !!";
			request.setAttribute("errorString", errorString);
		} else {
			errorString = "Total " + allAppointment.size() + " appointment found ";
			request.setAttribute("allAppointment", allAppointment);
			request.setAttribute("errorString", errorString);
		}

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/appointmentList.jsp");

		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
