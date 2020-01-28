package com.royel.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.royel.bean.RoomBuildingBean;
import com.royel.dao.DBManager;
import com.royel.utility.SessionCookiesUtility;

@WebServlet("/addRoom")
public class RoomRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RoomRegistrationController() {
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
				.getRequestDispatcher("/WEB-INF/views/roomRegistration.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		if (SessionCookiesUtility.loginedUserSessionIsInvalid(session)) {
			response.sendRedirect(request.getContextPath() + "/AdminLogin");
			return;
		}

		String errorString = null;

		RoomBuildingBean newRoom = new RoomBuildingBean(Integer.parseInt(request.getParameter("room_no")),
				request.getParameter("room_type"), request.getParameter("building"),
				Integer.parseInt(request.getParameter("price")), Integer.parseInt(request.getParameter("bed_no")),
				request.getParameter("room_status"));

		boolean isRoomAlreadyExist = DBManager.isRoomAlreadyExist(newRoom.getRoomNo(), newRoom.getBuildingName());

		if (!isRoomAlreadyExist) {
			if (DBManager.roomBuildingRegistration(newRoom)) {
				errorString = "New room " + newRoom.getRoomNo() + " is added :)";
			}

		} else if (isRoomAlreadyExist) {
			errorString = "Room " + newRoom.getRoomNo() + " of building " + newRoom.getBuildingName()
					+ " is already exist !!";
		} else {
			errorString = "Error Occured !! Your requested doctor data is not added !!";
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/error.jsp");
			dispatcher.forward(request, response);
		}

		request.setAttribute("errorString", errorString);

		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/roomRegistration.jsp");
		dispatcher.forward(request, response);
	}
}
