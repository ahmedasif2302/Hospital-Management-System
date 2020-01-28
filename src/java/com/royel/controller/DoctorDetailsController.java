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

@WebServlet("/doctorDetails")
public class DoctorDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DoctorDetailsController() {
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
		
		//int  count = (request.getParameter("counter") == null) ? 0 : Integer.parseInt(request.getParameter("counter"));
		
		String errorString = null;
		DoctorBean doctor = DBManager.seleOnectDoctor(did);

		if (doctor != null) {

			request.setAttribute("selectedDoctor", doctor);
			request.setAttribute("selectedId", did);

			RequestDispatcher dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/doctorDetails.jsp");

			dispatcher.forward(request, response);

		} else {

			errorString = "Your requested id " + did + " is not Found !!";
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/error.jsp");
			dispatcher.forward(request, response);

		}
	}
}
