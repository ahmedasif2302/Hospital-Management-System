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

import com.royel.bean.PatientsBean;
import com.royel.dao.DBManager;
import com.royel.utility.SessionCookiesUtility;

@WebServlet("/patientsList")
public class PatientsListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PatientsListController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		if (SessionCookiesUtility.loginedUserSessionIsInvalid(session)) {
			response.sendRedirect(request.getContextPath() + "/AdminLogin");
			return;
		}

		List<PatientsBean> allAvailablePatients = DBManager.selectAllPatientsData("Admitted");

		String errorString = null;
		String listHeading = null;

		if (allAvailablePatients.isEmpty()) {
			errorString = "No Current Patients data found !!";
			request.setAttribute("errorString", errorString);
		} else {
			listHeading = "OUR CURRENT PATIENTS";
			errorString = "Total " + allAvailablePatients.size() + " patients found ";
			request.setAttribute("listHeading", listHeading);
			request.setAttribute("allPatients", allAvailablePatients);
			request.setAttribute("errorString", errorString);
		}

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/patientsList.jsp");

		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
