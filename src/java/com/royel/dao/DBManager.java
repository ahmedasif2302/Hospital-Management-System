package com.royel.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import com.royel.bean.AppointmentBean;
import com.royel.bean.DoctorBean;
import com.royel.bean.EmployeeBean;
import com.royel.bean.MessageBean;
import com.royel.bean.PatientsBean;
import com.royel.bean.RoomBuildingBean;
import com.royel.bean.UserAccount;

/**
 * class DBManager
 * 
 * The intention of this class is to manage all method related with database.
 * This class created with public access modifiers, all method of this class can
 * be accessed by any class of this project. There is a Private attribute of
 * DBConnection types that used to get connection from DBConnect class
 * 
 * @author Royel
 * @version 1.0
 * @since 04/08/2017.
 * 
 */

public class DBManager {
	private static DBConnection connection = DBConnection.dbConnection();

	/**
	 * This method is used to register the patients.It takes user data and check
	 * it. If user data is valid, it stores it into patients table in the
	 * hospital database. Admin Can manage the data accessed by PatientsBean
	 * object
	 * 
	 * @param patients
	 *            This is PatientsBean types parameter
	 * @return boolean; .
	 */

	public static boolean patientsRegistration(PatientsBean patients) {

		String checkSql = "select * from patients where email = ?";
		boolean status = false;

		try {
			PreparedStatement ps = (PreparedStatement) connection.getPreparedStatement(checkSql);
			ps.setString(1, patients.getEmailNo());
			ResultSet rs = ps.executeQuery();

			if (!rs.next()) {
				String sql = "insert into patients(name, father_name, address,"
						+ " gender, age, blood_group, national_id, disease,"
						+ " entry_date, room_type, status, phone, email) "
						+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

				PreparedStatement statement = (PreparedStatement) connection.getPreparedStatement(sql);

				statement.setString(1, patients.getName());
				statement.setString(2, patients.getFatherName());
				statement.setString(3, patients.getAddress());
				statement.setString(4, patients.getGender());
				statement.setInt(5, patients.getAge());
				statement.setString(6, patients.getBloodGroup());
				statement.setString(7, patients.getNationalID());
				statement.setString(8, patients.getDisease());
				statement.setString(9, patients.getEntryDate());
				statement.setString(10, patients.getRoomType());
				statement.setString(11, patients.getStatus());
				statement.setString(12, patients.getPhoneNo());
				statement.setString(13, patients.getEmailNo());

				status = (statement.executeUpdate() > 0) ? true : false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return status;
	}

	/**
	 * This method is used to get a selected patients property from patients
	 * table and store it in a resultSet then store it within a PatientsBean
	 * class's object
	 * 
	 * @param id
	 *            This is int types parameter
	 * @return patients PatientsBean class object
	 */

	public static PatientsBean selectOnePatients(int id) {

		String sql = "select * from patients where pid=?";
		PatientsBean patients = null;

		PreparedStatement statement;
		try {
			statement = (PreparedStatement) connection.getPreparedStatement(sql);
			statement.setInt(1, id);

			ResultSet result = statement.executeQuery();
			while (result.next()) {
				patients = resultSetToPatientsConvert(result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return patients;
	}

	/**
	 * This method is used to select all data from patients table and store it
	 * in a resultSet then store it within a patients class's object
	 * 
	 * @param no
	 *            parameter
	 * @return PatientsBean an ArrayList of PatientsBean object.
	 */

	// select availabe patients.l
	public static List<PatientsBean> selectAllPatientsData(String status) {

		String sql = "select * from patients where status=? order by pid DESC";
		List<PatientsBean> availablePatients = new ArrayList<PatientsBean>();

		PreparedStatement statement;
		try {
			statement = (PreparedStatement) connection.getPreparedStatement(sql);
			statement.setString(1, status);

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				PatientsBean patients = resultSetToPatientsConvert(result);
				availablePatients.add(patients);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return availablePatients;
	}

	/**
	 * This method is used to get status of a selected patients from patients
	 * table
	 * 
	 * @param id
	 *            int type
	 * @return string types data.
	 */

	public static String getPatientsStatusFromID(int id) {
		String sql = "select status from patients where pid=?";

		try {
			PreparedStatement statement = (PreparedStatement) connection.getPreparedStatement(sql);
			statement.setInt(1, id);

			ResultSet result = statement.executeQuery();
			if (result.next()) {
				return result.getString("status");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * This method is used to update selected patients data from patients table
	 * 
	 * @param patients,
	 *            pid
	 * @return boolean.
	 */

	public static boolean updatePatientsData(PatientsBean patient, int pid) {

		String sql = "update patients set name=?, father_name=?, address=?,"
				+ " gender=?, age=?, blood_group=?, national_id=?, disease=?,"
				+ " entry_date=?, room_type=?, status=?, phone=?, email=?  where pid=?";

		PreparedStatement statement;
		try {
			statement = (PreparedStatement) connection.getPreparedStatement(sql);
			statement.setString(1, patient.getName());
			statement.setString(2, patient.getFatherName());
			statement.setString(3, patient.getAddress());
			statement.setString(4, patient.getGender());
			statement.setInt(5, patient.getAge());
			statement.setString(6, patient.getBloodGroup());
			statement.setString(7, patient.getNationalID());
			statement.setString(8, patient.getDisease());
			statement.setString(9, patient.getEntryDate());
			statement.setString(10, patient.getRoomType());
			statement.setString(11, patient.getStatus());
			statement.setString(12, patient.getPhoneNo());
			statement.setString(13, patient.getEmailNo());
			statement.setInt(14, pid);

			return statement.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

	/**
	 * This method is used to delete a specific elements from patients table
	 * provides user as input
	 * 
	 * @param id
	 *            This integer type parameter input id value from user
	 * @return boolean
	 */

	public static boolean deletePatientsData(int id) {

		String sql = "delete from patients where pid=?";

		PreparedStatement statement;
		try {
			statement = (PreparedStatement) connection.getPreparedStatement(sql);
			statement.setInt(1, id);

			return statement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * This method is used to convert resultset object to patients.
	 *
	 * @param result
	 *            a ResultSet type object
	 * @return PatientsBean type object
	 */

	private static PatientsBean resultSetToPatientsConvert(ResultSet result) throws SQLException {

		return new PatientsBean(result.getInt("pid"), result.getString("name"), result.getString("father_name"),
				result.getString("address"), result.getString("gender"), result.getInt("age"),
				result.getString("blood_group"), result.getString("national_id"), result.getString("disease"),
				result.getString("entry_date"), result.getString("room_type"), result.getString("status"),
				result.getString("phone"), result.getString("email"));
	}

	/*
	 * End of patients method.
	 * -------------------------------------------------------------------------
	 * -------------------------------------------------------------------------
	 * -------------------------------------------------------------------------
	 * ---
	 * -------------------------------------------------------------------------
	 * ----- start doctors method.
	 */

	public static boolean doctorRegistration(DoctorBean doctor) {

		boolean check = false;
		String checkSql = "select * from doctor where email = ?";

		try {

			PreparedStatement ps = (PreparedStatement) connection.getPreparedStatement(checkSql);
			ps.setString(1, doctor.getEmailNo());

			ResultSet rs = ps.executeQuery();

			if (!rs.next()) {

				String sql = "insert into doctor(name, qualification, designation, specialities,"
						+ " biodata, checkup_fee, phone, email) values(?, ?, ?, ?, ?, ?, ?, ?)";

				PreparedStatement statement = (PreparedStatement) connection.getPreparedStatement(sql);

				statement.setString(1, doctor.getName());
				statement.setString(2, doctor.getQualification());
				statement.setString(3, doctor.getDesignation());
				statement.setString(4, doctor.getSpecialities());
				statement.setString(5, doctor.getBiodata());
				statement.setInt(6, doctor.getCheckupFee());
				statement.setString(7, doctor.getPhoneNo());
				statement.setString(8, doctor.getEmailNo());

				check = (statement.executeUpdate() > 0) ? true : false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

	public static DoctorBean seleOnectDoctor(int id) {

		String sql = "select * from doctor where did=?";
		DoctorBean doctor = null;

		try {
			PreparedStatement statement = (PreparedStatement) connection.getPreparedStatement(sql);
			statement.setInt(1, id);

			ResultSet result = statement.executeQuery();
			while (result.next()) {
				doctor = resultSetToDoctorConverter(result);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return doctor;
	}

	public static List<DoctorBean> selectAllDoctorData() {

		String sql = "select * from doctor order by did DESC";
		List<DoctorBean> allDoctor = new ArrayList<DoctorBean>();

		try {
			PreparedStatement statement = (PreparedStatement) connection.getPreparedStatement(sql);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				DoctorBean doctor = resultSetToDoctorConverter(result);
				allDoctor.add(doctor);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return allDoctor;
	}

	public static boolean updateDoctorsData(DoctorBean doctor, int did) {

		boolean status = false;

		String sql = "update doctor set name=?, qualification=?, designation=?, "
				+ "specialities=?, biodata=?, checkup_fee=?, phone=?, email=? where did=?";

		try {
			PreparedStatement statement = (PreparedStatement) connection.getPreparedStatement(sql);

			statement.setString(1, doctor.getName());
			statement.setString(2, doctor.getQualification());
			statement.setString(3, doctor.getDesignation());
			statement.setString(4, doctor.getSpecialities());
			statement.setString(5, doctor.getBiodata());
			statement.setInt(6, doctor.getCheckupFee());
			statement.setString(7, doctor.getPhoneNo());
			statement.setString(8, doctor.getEmailNo());
			statement.setInt(9, did);

			status = (statement.executeUpdate() > 0) ? true : false;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return status;
	}

	public static boolean deleteDoctorFromDatabase(int id) {

		String sql = "delete from doctor where did=?";
		boolean status = false;

		try {
			PreparedStatement statement = (PreparedStatement) connection.getPreparedStatement(sql);
			statement.setInt(1, id);
			status = (statement.executeUpdate() > 0) ? true : false;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return status;
	}

	private static DoctorBean resultSetToDoctorConverter(ResultSet result) throws SQLException {

		return new DoctorBean(result.getInt("did"), result.getString("name"), result.getString("qualification"),
				result.getString("designation"), result.getString("specialities"), result.getString("biodata"),
				result.getInt("checkup_fee"), result.getString("phone"), result.getString("email"));
	}

	public static int countAllDoctor() throws SQLException {

		String sql = "SELECT COUNT(*) As totalDoctor FROM doctor";
		int totalDoctor = 0;

		PreparedStatement statement = (PreparedStatement) connection.getPreparedStatement(sql);
		ResultSet result = statement.executeQuery();

		if (result.next()) {
			totalDoctor = result.getInt("totalDoctor");
		}

		return totalDoctor;
	}

	/*
	 * -------------------------------------------------------------------------
	 * ------------------ start patients appointment
	 * -------------------------------------------------------------------------
	 * -----------------
	 */

	public static boolean createAppointment(AppointmentBean appointment) {

		String checkSql = "select * from appointment where phone=?";
		boolean check = false;
		System.out.println(" beforequesry exequted");

		try {

			PreparedStatement ps = (PreparedStatement) connection.getPreparedStatement(checkSql);
			ps.setString(1, appointment.getPhone());

			ResultSet rs = ps.executeQuery();

			if (!rs.next()) {

				String sql = "insert into appointment(name, email, phone, gender, age, specialization,"
						+ " date, status ) values(?, ?, ?, ?, ?, ?, ?, ?)";
				System.out.println("quesry exequted");

				PreparedStatement statement = (PreparedStatement) connection.getPreparedStatement(sql);
				statement.setString(1, appointment.getPatientsName());
				statement.setString(2, appointment.getEmail());
				statement.setString(3, appointment.getPhone());
				statement.setString(4, appointment.getGender());
				statement.setInt(5, appointment.getAge());
				statement.setString(6, appointment.getDoctorName());
				statement.setString(7, appointment.getDate());
				statement.setString(8, "pending");

				check = (statement.executeUpdate() > 0) ? true : false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	public static List<AppointmentBean> selectAllAppointments() {

		String sql = "select * from appointment order by id DESC";
		List<AppointmentBean> allAppointment = new ArrayList<AppointmentBean>();

		try {
			PreparedStatement statement = (PreparedStatement) connection.getPreparedStatement(sql);
			ResultSet result = statement.executeQuery();

			while (result.next()) {

				AppointmentBean appointment = new AppointmentBean(result.getInt("id"), result.getString("name"),
						result.getString("email"), result.getString("phone"), result.getString("gender"),
						result.getInt("age"), result.getString("specialization"), result.getString("date"),
						result.getString("status"));
				allAppointment.add(appointment);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return allAppointment;
	}

	public static boolean deleteExistingAppointment(int id) {

		String sql = "delete from appointment where id=?";
		boolean status = false;

		try {
			PreparedStatement statement = (PreparedStatement) connection.getPreparedStatement(sql);
			statement.setInt(1, id);
			status = (statement.executeUpdate() > 0) ? true : false;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return status;
	}

	public static boolean isDoctorAvaibale(String specialization, String date) {

		int totalDoctor = 0;
		int totalParients = 0;

		String sql = "SELECT (SELECT COUNT(*) from doctor where specialities= '" + specialization
				+ "') As totalDoctor, " + "(SELECT COUNT(*) from appointment where specialization= '" + specialization
				+ "' and date= '" + date + "') As totalPatients";

		try {
			PreparedStatement ps = (PreparedStatement) connection.getPreparedStatement(sql);

			ResultSet result = ps.executeQuery();

			if (result.next()) {
				totalDoctor = result.getInt("totalDoctor");
				totalParients = result.getInt("totalPatients");
			}

			// Each doctor will check 10 patients. if number of total
			// patients less then totalDoctor * 10, then returns true

			if (totalDoctor != 0) {
				return ((totalDoctor * 5) > totalParients) ? true : false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	// ==============================================================================

	/*
	 * employee part.
	 */

	public static boolean employeeRegistration(EmployeeBean employee) {
		boolean status = false;

		String checkSql = "select * from employee where email=?";

		try {
			PreparedStatement ps = (PreparedStatement) connection.getPreparedStatement(checkSql);
			ps.setString(1, employee.getEmail());
			ResultSet rs = ps.executeQuery();

			if (!rs.next()) {

				String sql = "insert into employee (name, father_name, address, gender, age, qualification,"
						+ " designation, blood_group, nid, joining_date, salary, phone, email)"
						+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

				PreparedStatement statement = (PreparedStatement) connection.getPreparedStatement(sql);

				statement.setString(1, employee.getName());
				statement.setString(2, employee.getFatherName());
				statement.setString(3, employee.getAddress());
				statement.setString(4, employee.getGender());
				statement.setInt(5, employee.getAge());
				statement.setString(6, employee.getQualification());
				statement.setString(7, employee.getDesignation());
				statement.setString(8, employee.getBloodGroup());
				statement.setString(9, employee.getNationalID());
				statement.setString(10, employee.getJoiningDate());
				statement.setInt(11, employee.getSalary());
				statement.setString(12, employee.getMobileNo());
				statement.setString(13, employee.getEmail());

				status = (statement.executeUpdate() > 0) ? true : false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return status;
	}

	public static EmployeeBean selectOneEmployee(int id) {

		String sql = "select * from employee where eid=?";
		EmployeeBean employee = null;

		try {
			PreparedStatement statement = (PreparedStatement) connection.getPreparedStatement(sql);
			statement.setInt(1, id);

			ResultSet result = statement.executeQuery();
			if (result.next()) {
				employee = resultSetToEmployeeConverter(result);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employee;
	}

	public static List<EmployeeBean> selectAllEmployee() {

		String sql = "select * from employee order by eid DESC";
		List<EmployeeBean> allEmployee = new ArrayList<EmployeeBean>();

		try {
			PreparedStatement statement = (PreparedStatement) connection.getPreparedStatement(sql);
			ResultSet results = statement.executeQuery();

			while (results.next()) {
				EmployeeBean employee = resultSetToEmployeeConverter(results);
				allEmployee.add(employee);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return allEmployee;
	}

	public static boolean updateEmployeData(EmployeeBean employee, int eid) {

		boolean check = false;

		String sql = "update employee set name=?, father_name=?, address=?, gender=?, age=?, qualification=?,"
				+ "designation=?, blood_group=?, nid=?, joining_date=?, salary=?, phone=?, email=? where eid=?";

		try {
			PreparedStatement statement = (PreparedStatement) connection.getPreparedStatement(sql);
			statement.setString(1, employee.getName());
			statement.setString(2, employee.getFatherName());
			statement.setString(3, employee.getAddress());
			statement.setString(4, employee.getGender());
			statement.setInt(5, employee.getAge());
			statement.setString(6, employee.getQualification());
			statement.setString(7, employee.getDesignation());
			statement.setString(8, employee.getBloodGroup());
			statement.setString(9, employee.getNationalID());
			statement.setString(10, employee.getJoiningDate());
			statement.setInt(11, employee.getSalary());
			statement.setString(12, employee.getMobileNo());
			statement.setString(13, employee.getEmail());
			statement.setInt(14, eid);

			check = (statement.executeUpdate() > 0) ? true : false;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	public static boolean deleteEmployeeData(int id) {
		String sql = "delete from employee where eid=?";
		boolean check = false;

		try {
			PreparedStatement statement = (PreparedStatement) connection.getPreparedStatement(sql);
			statement.setInt(1, id);

			check = (statement.executeUpdate() > 0) ? true : false;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	private static EmployeeBean resultSetToEmployeeConverter(ResultSet result) throws SQLException {
		return new EmployeeBean(result.getInt("eid"), result.getString("name"), result.getString("father_name"),
				result.getString("address"), result.getString("gender"), result.getInt("age"),
				result.getString("qualification"), result.getString("designation"), result.getString("blood_group"),
				result.getString("nid"), result.getString("joining_date"), result.getInt("salary"),
				result.getString("phone"), result.getString("email"));
	}

	/*
	 * 
	 * 
	 * room and building part.
	 * 
	 * 
	 */

	/*
	 * 
	 * add room building
	 */

	public static boolean isRoomAlreadyExist(int roomNumber, String buildingName) {

		String checkSql = "select * from roombuilding where room_no=? and building_name=?";

		try {
			PreparedStatement ps = (PreparedStatement) connection.getPreparedStatement(checkSql);
			ps.setInt(1, roomNumber);
			ps.setString(2, buildingName);

			ResultSet rs = ps.executeQuery();

			return (rs.next()) ? true : false;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public static boolean roomBuildingRegistration(RoomBuildingBean roomBuilding) {

		String sql = "insert into roombuilding (room_no , room_type, building_name,"
				+ " room_price, no_of_bed, status) values(?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement statement = (PreparedStatement) connection.getPreparedStatement(sql);

			statement.setInt(1, roomBuilding.getRoomNo());
			statement.setString(2, roomBuilding.getRoomType());
			statement.setString(3, roomBuilding.getBuildingName());
			statement.setInt(4, roomBuilding.getRoomPrice());
			statement.setInt(5, roomBuilding.getNumberOfBed());
			statement.setString(6, roomBuilding.getRoomStatus());

			return (statement.executeUpdate() > 0) ? true : false;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public static List<RoomBuildingBean> selectAllRoomData() {

		String sql = "select * from roombuilding";
		List<RoomBuildingBean> allRooms = new ArrayList<RoomBuildingBean>();

		try {
			PreparedStatement statement = (PreparedStatement) connection.getPreparedStatement(sql);
			ResultSet result = statement.executeQuery();
			RoomBuildingBean room;
			while (result.next()) {
				room = new RoomBuildingBean(result.getInt("rid"), result.getInt("room_no"),
						result.getString("room_type"), result.getString("building_name"), result.getInt("room_price"),
						result.getInt("no_of_bed"), result.getString("status"));

				allRooms.add(room);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return allRooms;
	}

	public static boolean deleteRoomBuildingData(int rid) {
		String sql = "delete from roombuilding where rid=?";

		try {
			PreparedStatement statement = (PreparedStatement) connection.getPreparedStatement(sql);
			statement.setInt(1, rid);
			return statement.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	/*
	 * 
	 * -------------------------------------------------------------------------
	 * ------------ ---------------------------------- Homepage Data
	 * -----------------------------------
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * ++++++++++++
	 */

	public static int[] countAllTableDataTogather() {

		int[] totaldata = new int[4];

		String sql = "SELECT" + "(SELECT COUNT(*) FROM patients) As totalPatients,"
				+ "(SELECT COUNT(*) FROM doctor) As totalDoctor," + "(SELECT COUNT(*) FROM employee) As totalEmployee,"
				+ "(SELECT COUNT(*) FROM appointment) As totalAppointment";

		try {
			PreparedStatement statement = (PreparedStatement) connection.getPreparedStatement(sql);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				totaldata[0] = result.getInt("totalPatients");
				totaldata[1] = result.getInt("totalDoctor");
				totaldata[2] = result.getInt("totalEmployee");
				totaldata[3] = result.getInt("totalAppointment");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return totaldata;
	}

	/*
	 * 
	 * -------------------------------------------------------------------------
	 * ------------
	 * -------------------------------------------------------------------------
	 * ------------
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * ++++++++++++
	 */

	public static UserAccount findUser(String userName, String password) throws SQLException {

		String sql = "Select a.user_name, a.user_image, a.password from user_account a "
				+ " where a.user_name = ? and a.password= ?";

		PreparedStatement statement = (PreparedStatement) connection.getPreparedStatement(sql);
		statement.setString(1, userName);
		statement.setString(2, password);
		ResultSet rs = statement.executeQuery();

		if (rs.next()) {
			String userImage = rs.getString("user_image");

			return new UserAccount(userName, userImage, password);
		}
		return null;
	}

	/*
	 * 
	 * -------------------------------------------------------------------------
	 * ------------
	 * -------------------------------------------------------------------------
	 * ------------
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * ++++++++++++
	 */

	public static boolean registerMessageIntoDB(MessageBean userMessage) {

		String sql = "insert into inbox(name, email, message) values(?, ?, ?)";

		try {
			PreparedStatement statement = (PreparedStatement) connection.getPreparedStatement(sql);
			statement.setString(1, userMessage.getName());
			statement.setString(2, userMessage.getEmail());
			statement.setString(3, userMessage.getMessage());

			return (statement.executeUpdate() > 0) ? true : false;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	
	
	public static List<MessageBean> selectAllMessage() {

		String sql = "select * from inbox";
		
		List<MessageBean> allMessage = new ArrayList<MessageBean>();

		try {
			PreparedStatement statement = (PreparedStatement) connection.getPreparedStatement(sql);
			ResultSet result = statement.executeQuery();
			MessageBean message;
			while (result.next()) {
				message = new MessageBean(
						result.getInt("mid"),
						result.getString("name"),
						result.getString("email"),
						result.getString("message"));

				allMessage.add(message);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return allMessage;
	}
	
	
	
	public static boolean deleteSelectedMessage(int id) {

		String sql = "delete from inbox where mid=?";

		try {
			PreparedStatement statement = (PreparedStatement) connection.getPreparedStatement(sql);
			statement.setInt(1, id);

			return (statement.executeUpdate() > 0) ? true : false;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	
	
	
//
//	public static void main(String args[]) {
//
//		AppointmentBean appointment = new AppointmentBean("royel", "dfjhsgfjhs@gmail.com", "01723051581", "male", 22,
//				"Anis", "27/22/22");
//
//		boolean chechk = DBManager.createAppointment(appointment);
//
//		System.out.println(chechk);
//	}

}
