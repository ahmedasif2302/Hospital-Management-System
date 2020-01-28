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

@WebServlet("/patientsDetails")
public class PatientsDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PatientsDetailsController() {
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

		int did = Integer.parseInt(request.getParameter("view_id"));
		String errorString = null;
		PatientsBean selectedPatients = DBManager.selectOnePatients(did);

		if (selectedPatients != null) {

			String patientsListControllerPath = null;

			patientsListControllerPath = (selectedPatients.getStatus().equals("Admitted")) ? "patientsList"
					: "formerPatients";

			request.setAttribute("patients", selectedPatients);
			request.setAttribute("path", patientsListControllerPath);
			RequestDispatcher dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/patientsDetails.jsp");

			dispatcher.forward(request, response);

		} else {

			errorString = "Your requested id " + did + " is not Found !!";
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/error.jsp");
			dispatcher.forward(request, response);

		}
	}
}
