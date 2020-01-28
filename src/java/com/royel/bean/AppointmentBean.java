package com.royel.bean;

public class AppointmentBean {

	private int id;
	private String patientsName;
	private String email;
	private String phone;
	private String gender;
	private int age;
	private String doctorName;
	private String date;
	private String status;

	public AppointmentBean() {
		super();
	}
	
	public AppointmentBean(String patientsName, String email, String phone, String gender, int age, String doctorName,
			String date) {
		super();
		this.patientsName = patientsName;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.age = age;
		this.doctorName = doctorName;
		this.date = date;
	}

	public AppointmentBean(String patientsName, String email, String phone, String gender, int age, String doctorName,
			String date, String status) {
		super();
		this.patientsName = patientsName;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.age = age;
		this.doctorName = doctorName;
		this.date = date;
		this.status = status;
	}

	public AppointmentBean(int id, String patientsName, String email, String phone, String gender, int age,
			String doctorName, String date, String status) {
		super();
		this.id = id;
		this.patientsName = patientsName;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.age = age;
		this.doctorName = doctorName;
		this.date = date;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPatientsName() {
		return patientsName;
	}

	public void setPatientsName(String patientsName) {
		this.patientsName = patientsName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

	
}
