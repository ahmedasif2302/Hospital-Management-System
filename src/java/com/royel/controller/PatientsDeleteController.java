package com.royel.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.royel.dao.DBManager;
import com.royel.utility.SessionCookiesUtility;

@WebServlet("/patientsDelete")
public class PatientsDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PatientsDeleteController() {
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

		int pid = Integer.parseInt(request.getParameter("pid"));
	
		String status = DBManager.getPatientsStatusFromID(pid);
		String errorString = null;

		if (DBManager.deletePatientsData(pid)) {

			String patientsListContsrollerPath = null;

			patientsListContsrollerPath = (status.equals("Admitted")) ? "/patientsList" : "/formerPatients";

			response.sendRedirect(request.getContextPath() + patientsListContsrollerPath);

		} else {
			errorString = "Your requested id " + pid + " is not deleted !!";
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/error.jsp");
			dispatcher.forward(request, response);
		}
	}

}
