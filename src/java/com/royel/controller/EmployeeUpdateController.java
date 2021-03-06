package com.royel.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.royel.bean.EmployeeBean;
import com.royel.dao.DBManager;
import com.royel.utility.SessionCookiesUtility;

@WebServlet("/employeeUpdate")
public class EmployeeUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmployeeUpdateController() {
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

		EmployeeBean employee = null;
		String errorStirng = null;

		employee = new EmployeeBean(Integer.parseInt(request.getParameter("eid")), request.getParameter("name"),
				request.getParameter("father_name"), request.getParameter("address"), request.getParameter("gender"),
				Integer.parseInt(request.getParameter("age")), request.getParameter("qualification"),
				request.getParameter("designation"), request.getParameter("blood_group"),
				request.getParameter("national_id"), request.getParameter("joining_date"),
				Integer.parseInt(request.getParameter("salary")), request.getParameter("phone_no"),
				request.getParameter("email"));

		int eid = employee.getEid();

		if (DBManager.updateEmployeData(employee, eid)) {

			errorStirng = "Employee data has been updated !! ";

			request.setAttribute("errorString", errorStirng);
			request.setAttribute("employee", employee);

			RequestDispatcher dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/employeeDetails.jsp");

			dispatcher.forward(request, response);

		} else {
			errorStirng = "Error Occured !! Your requested Employee " + eid + " is not updated !!";

			request.setAttribute("errorString", errorStirng);

			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/error.jsp");
			dispatcher.forward(request, response);

		}
	}

}
