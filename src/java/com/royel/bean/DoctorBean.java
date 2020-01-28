package com.royel.bean;

public class DoctorBean {

	private int did;
	private String name;
	private String qualification;
	private String designation;
	private String specialities;
	private String biodata;
	private int checkupFee;
	private String phoneNo;
	private String emailNo;

	public DoctorBean() {
		super();
	}

	public DoctorBean(String name, String qualification, String designation, String specialities, String biodata,
			int checkupFee, String phoneNo, String emailNo) {
		super();
		this.name = name;
		this.qualification = qualification;
		this.designation = designation;
		this.specialities = specialities;
		this.biodata = biodata;
		this.checkupFee = checkupFee;
		this.phoneNo = phoneNo;
		this.emailNo = emailNo;
	}

	public DoctorBean(int did, String name, String qualification, String designation, String specialities,
			String biodata, int checkupFee, String phoneNo, String emailNo) {
		super();
		this.did = did;
		this.name = name;
		this.qualification = qualification;
		this.designation = designation;
		this.specialities = specialities;
		this.biodata = biodata;
		this.checkupFee = checkupFee;
		this.phoneNo = phoneNo;
		this.emailNo = emailNo;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getSpecialities() {
		return specialities;
	}

	public void setSpecialities(String specialities) {
		this.specialities = specialities;
	}

	public String getBiodata() {
		return biodata;
	}

	public void setBiodata(String biodata) {
		this.biodata = biodata;
	}

	public int getCheckupFee() {
		return checkupFee;
	}

	public void setCheckupFee(int checkupFee) {
		this.checkupFee = checkupFee;
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
