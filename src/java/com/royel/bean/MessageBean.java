package com.royel.bean;

public class MessageBean {
	
	private int mid;
	private String name;
	private String email;
	private String message;
	
	public MessageBean() {
		super();
	}

	public MessageBean(String name, String email, String message) {
		super();
		this.name = name;
		this.email = email;
		this.message = message;
	}

	public MessageBean(int mid, String name, String email, String message) {
		super();
		this.mid = mid;
		this.name = name;
		this.email = email;
		this.message = message;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
