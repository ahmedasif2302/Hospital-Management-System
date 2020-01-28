package com.royel.bean;

public class PatientsBean {
	private int pid;
	private String name;
	private String fatherName;
	private String address;
	private String gender;
	private int age;
	private String bloodGroup;
	private String nationalID;
	private String disease;
	private String entryDate;
	private String roomType;
	private String status;
	private String phoneNo;
	private String emailNo;

	public PatientsBean() {
		super();
	}

	public PatientsBean(String name, String fatherName, String address, String gender, int age, String bloodGroup,
			String nationalID, String disease, String entryDate, String roomType, String status, String phoneNo,
			String emailNo) {
		super();
		this.name = name;
		this.fatherName = fatherName;
		this.address = address;
		this.gender = gender;
		this.age = age;
		this.bloodGroup = bloodGroup;
		this.nationalID = nationalID;
		this.disease = disease;
		this.entryDate = entryDate;
		this.roomType = roomType;
		this.status = status;
		this.phoneNo = phoneNo;
		this.emailNo = emailNo;
	}

	public PatientsBean(int pid, String name, String fatherName, String address, String gender, int age,
			String bloodGroup, String nationalID, String disease, String entryDate, String roomType, String status,
			String phoneNo, String emailNo) {
		super();
		this.pid = pid;
		this.name = name;
		this.fatherName = fatherName;
		this.address = address;
		this.gender = gender;
		this.age = age;
		this.bloodGroup = bloodGroup;
		this.nationalID = nationalID;
		this.disease = disease;
		this.entryDate = entryDate;
		this.roomType = roomType;
		this.status = status;
		this.phoneNo = phoneNo;
		this.emailNo = emailNo;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getNationalID() {
		return nationalID;
	}

	public void setNationalID(String nationalID) {
		this.nationalID = nationalID;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmailNo() {
		return emailNo;
	}

	public void setEmailNo(String emailNo) {
		this.emailNo = emailNo;
	}

}
