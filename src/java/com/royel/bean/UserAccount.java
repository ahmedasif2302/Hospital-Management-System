package com.royel.bean;

public class UserAccount {
	
	private String userName;
	private String userImage;
	private String password;
	
	public UserAccount() {
		super();
	}

	public UserAccount(String userName, String userImage, String password) {
		super();
		this.userName = userName;
		this.userImage = userImage;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
