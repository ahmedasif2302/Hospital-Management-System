package com.royel.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.royel.bean.AppointmentBean;
import com.royel.dao.DBManager;
import com.royel.sendsms.SmsSendingUtility;
import com.royel.utility.SessionCookiesUtility;

@WebServlet("/getAppointment")
public class AppointmentRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AppointmentRegistrationController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/appointmentOnline.jsp");

		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AppointmentBean appointment = receiveDataFromAppointmentForm(request);

		System.out.println("Data receive in form");

		String errorString = null;

		if (SmsSendingUtility.checkPhoneNumber(appointment.getPhone()) && SmsSendingUtility.isInternetConnectionAvailable()) {

			System.out.println("Phone number is valid");
			if (DBManager.isDoctorAvaibale(appointment.getDoctorName(), appointment.getDate())) {

				System.out.println("doctor is available.");
				String randomCode = String.valueOf(SmsSendingUtility.generateRandomNumber());

				try {
					int status = SmsSendingUtility.sendGet(appointment.getPhone(), randomCode);

					System.out.println("Message function is called..");

					if (status == 200) {
						HttpSession session = request.getSession();

						System.out.println("Message is sent");

						SessionCookiesUtility.storeAppointmentConfirmationMobileNo(session, appointment, randomCode);
						System.out.println("Session cookie is stored");

						RequestDispatcher dispatcher = this.getServletContext()
								.getRequestDispatcher("/WEB-INF/views/appointmentVerification.jsp");

						dispatcher.forward(request, response);

						return;

					} else {
						errorString = "Network error !!";
						System.out.println(errorString);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else {
				errorString = "No doctor available";
				System.out.println("no doctor available");
			}
		} else {
			errorString = "Invalid phone number";
			System.out.println("invalid phone number");
		}

		request.setAttribute("errorString", errorString);

		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/appointmentOnline.jsp");

		dispatcher.forward(request, response);
	}

	private AppointmentBean receiveDataFromAppointmentForm(HttpServletRequest request) {
		return new AppointmentBean(
			request.getParameter("name"),
		    request.getParameter("email"),
			request.getParameter("phone"),
			request.getParameter("gender"),
			Integer.parseInt(request.getParameter("age")),
			request.getParameter("specialization"),
			request.getParameter("date"));
	}

	/*
	 * private boolean isStringInt(String s) { try { Integer.parseInt(s); return
	 * true; } catch (NumberFormatException ex) { return false; } }
	 */

}
