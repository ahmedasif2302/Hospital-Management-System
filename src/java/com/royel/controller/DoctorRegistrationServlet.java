package com.royel.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.royel.bean.DoctorBean;
import com.royel.dao.DBManager;
import com.royel.utility.SessionCookiesUtility;

@WebServlet("/addDoctor")
public class DoctorRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DoctorRegistrationServlet() {
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
				.getRequestDispatcher("/WEB-INF/views/doctorRegistration.jsp");

		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		if (SessionCookiesUtility.loginedUserSessionIsInvalid(session)) {
			response.sendRedirect(request.getContextPath() + "/AdminLogin");
			return;
		}

		DoctorBean newDoctor = new DoctorBean(request.getParameter("name"), request.getParameter("qualification"),
				request.getParameter("designation"), request.getParameter("specialities"),
				request.getParameter("biodata"), Integer.parseInt(request.getParameter("checkup_fee")),
				request.getParameter("phone_no"), request.getParameter("email"));

		String errorString = null;

		if (DBManager.doctorRegistration(newDoctor)) {

			errorString = "New doctor has been added :)";
			request.setAttribute("errorString", errorString);

			RequestDispatcher dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/doctorRegistration.jsp");

			dispatcher.forward(request, response);

		} else {

			errorString = "Error Occured !! Your requested doctor data is not added !!";
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/error.jsp");
			dispatcher.forward(request, response);

		}
	}

}
