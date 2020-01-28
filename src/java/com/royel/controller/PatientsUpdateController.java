package com.royel.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.royel.bean.PatientsBean;
import com.royel.dao.DBManager;
import com.royel.utility.SessionCookiesUtility;

@WebServlet("/patientsUpdate")
public class PatientsUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PatientsUpdateController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		if (SessionCookiesUtility.loginedUserSessionIsInvalid(session)) {
			response.sendRedirect(request.getContextPath() + "/AdminLogin");
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		if (SessionCookiesUtility.loginedUserSessionIsInvalid(session)) {
			response.sendRedirect(request.getContextPath() + "/AdminLogin");
			return;
		}

		PatientsBean patients = null;
		String errorString = null;

		patients = new PatientsBean(Integer.parseInt(request.getParameter("pid")), request.getParameter("name"),
				request.getParameter("father_name"), request.getParameter("address"), request.getParameter("gender"),
				Integer.parseInt(request.getParameter("age")), request.getParameter("blood_group"),
				request.getParameter("national_id"), request.getParameter("disease"), request.getParameter("date"),
				request.getParameter("room_type"), request.getParameter("status"), request.getParameter("phone_no"),
				request.getParameter("email"));

		int pid = patients.getPid();

		if (DBManager.updatePatientsData(patients, pid)) {
			errorString = "Your requested id " + pid + " is Updated !!";
			request.setAttribute("errorString", errorString);
			request.setAttribute("patients", patients);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/patientsDetails.jsp");
			dispatcher.forward(request, response);

		} else {
			errorString = "Your requested id " + pid + " is not Updated !!";
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/error.jsp");
			dispatcher.forward(request, response);
		}

	}

}
