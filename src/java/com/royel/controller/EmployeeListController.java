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

import com.royel.bean.EmployeeBean;
import com.royel.dao.DBManager;
import com.royel.utility.SessionCookiesUtility;

@WebServlet("/employeeList")
public class EmployeeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmployeeListController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		if (SessionCookiesUtility.loginedUserSessionIsInvalid(session)) {
			response.sendRedirect(request.getContextPath() + "/AdminLogin");
			return;
		}

		List<EmployeeBean> allEmployee = DBManager.selectAllEmployee();
		String errorString = null;

		if (allEmployee.isEmpty()) {
			errorString = "No employee data found !!! ";
			request.setAttribute("errorString", errorString);
		} else {

			errorString = "Total " + allEmployee.size() + " employee found ";
			request.setAttribute("allEmployee", allEmployee);
			request.setAttribute("errorString", errorString);
		}
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/employeeList.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
