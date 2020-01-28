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

@WebServlet("/doctorUpdate")
public class DoctorUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DoctorUpdateController() {
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

		DoctorBean doctor = new DoctorBean(Integer.parseInt(request.getParameter("did")),request.getParameter("name"),
				request.getParameter("qualification"),
				request.getParameter("designation"), request.getParameter("specialities"),
				request.getParameter("biodata"), Integer.parseInt(request.getParameter("checkup_fee")),
				request.getParameter("phone_no"), request.getParameter("email"));

		int id = doctor.getDid();
		String errorString = null;

		if (DBManager.updateDoctorsData(doctor, id)) {

			errorString = "Your requested id " + id + " is Updated !!";
			request.setAttribute("errorString", errorString);
			request.setAttribute("selectedDoctor", doctor);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/doctorDetails.jsp");
			dispatcher.forward(request, response);

		} else {
			errorString = "Your requested id " + id + " is not Updated !!";
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/error.jsp");
			dispatcher.forward(request, response);
		}
	}

}
