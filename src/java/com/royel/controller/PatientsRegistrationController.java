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

@WebServlet("/addPatients")
public class PatientsRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PatientsRegistrationController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		if (SessionCookiesUtility.loginedUserSessionIsInvalid(session)) {
			response.sendRedirect(request.getContextPath() + "/AdminLogin");
			return;
		}

		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/patientsRegistration.jsp");

		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		if (SessionCookiesUtility.loginedUserSessionIsInvalid(session)) {
			response.sendRedirect(request.getContextPath() + "/AdminLogin");
			return;
		}

		PatientsBean newPatients = null;

		newPatients = new PatientsBean(request.getParameter("name"), request.getParameter("father_name"),
				request.getParameter("address"), request.getParameter("gender"),
				Integer.parseInt(request.getParameter("age")), request.getParameter("blood_group"),
				request.getParameter("national_id"), request.getParameter("disease"), request.getParameter("date"),
				request.getParameter("room_type"), request.getParameter("status"), request.getParameter("phone_no"),
				request.getParameter("email"));

		String errorStirng = null;

		if (DBManager.patientsRegistration(newPatients)) {

			errorStirng = "New patients has been added";

			request.setAttribute("errorString", errorStirng);

			RequestDispatcher dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/patientsRegistration.jsp");
			dispatcher.forward(request, response);

		} else {

			errorStirng = "Error Occured !! Your requested patients data is not added !!";

			request.setAttribute("errorString", errorStirng);

			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/error.jsp");
			dispatcher.forward(request, response);

		}
	}

}
