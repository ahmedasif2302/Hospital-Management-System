package com.royel.bean;

public class EmployeeBean {

	private int eid;
	private String name;
	private String fatherName;
	private String address;
	private String gender;
	private int age;
	private String qualification;
	private String designation;
	private String bloodGroup;
	private String nationalID;
	private String joiningDate;
	private int salary;
	private String mobileNo;
	private String email;

	public EmployeeBean() {
		super();
	}

	public EmployeeBean(String name, String fatherName, String address, String gender, int age, String qualification,
			String designation, String bloodGroup, String nationalID, String joiningDate, int salary, String mobileNo,
			String email) {
		super();
		this.name = name;
		this.fatherName = fatherName;
		this.address = address;
		this.gender = gender;
		this.age = age;
		this.qualification = qualification;
		this.designation = designation;
		this.bloodGroup = bloodGroup;
		this.nationalID = nationalID;
		this.joiningDate = joiningDate;
		this.salary = salary;
		this.mobileNo = mobileNo;
		this.email = email;
	}

	public EmployeeBean(int eid, String name, String fatherName, String address, String gender, int age,
			String qualification, String designation, String bloodGroup, String nationalID, String joiningDate,
			int salary, String mobileNo, String email) {
		super();
		this.eid = eid;
		this.name = name;
		this.fatherName = fatherName;
		this.address = address;
		this.gender = gender;
		this.age = age;
		this.qualification = qualification;
		this.designation = designation;
		this.bloodGroup = bloodGroup;
		this.nationalID = nationalID;
		this.joiningDate = joiningDate;
		this.salary = salary;
		this.mobileNo = mobileNo;
		this.email = email;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
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

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
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

	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
