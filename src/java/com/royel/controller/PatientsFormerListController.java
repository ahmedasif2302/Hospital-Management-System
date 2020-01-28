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

@WebServlet("/formerPatients")
public class PatientsFormerListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PatientsFormerListController() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		if (SessionCookiesUtility.loginedUserSessionIsInvalid(session)) {
			response.sendRedirect(request.getContextPath() + "/AdminLogin");
			return;
		}

		List<PatientsBean> allRelesedPatients = DBManager.selectAllPatientsData("Relesed");

		String errorString = null;
		String listHeading = null;

		if (allRelesedPatients.isEmpty()) {
			errorString = "No former Patients  data found !!";
			request.setAttribute("errorString", errorString);
		} else {
			listHeading ="OUR FORMER PATIENTS";
			errorString = "Total " + allRelesedPatients.size() + " patients found ";
			request.setAttribute("listHeading", listHeading);
			request.setAttribute("allPatients", allRelesedPatients);
			request.setAttribute("errorString", errorString);
		}

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/patientsList.jsp");

		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
