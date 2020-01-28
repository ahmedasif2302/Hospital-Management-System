package com.royel.bean;

public class RoomBuildingBean {

	private int rid;
	private int roomNo;
	private String roomType;
	private String buildingName;
	private int roomPrice;
	private int numberOfBed;
	private String roomStatus;

	public RoomBuildingBean() {
		super();
	}

	public RoomBuildingBean(int roomNo, String roomType, String buildingName, int roomPrice, int numberOfBed,
			String roomStatus) {
		super();
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.buildingName = buildingName;
		this.roomPrice = roomPrice;
		this.numberOfBed = numberOfBed;
		this.roomStatus = roomStatus;
	}

	public RoomBuildingBean(int rid, int roomNo, String roomType, String buildingName, int roomPrice, int numberOfBed,
			String roomStatus) {
		super();
		this.rid = rid;
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.buildingName = buildingName;
		this.roomPrice = roomPrice;
		this.numberOfBed = numberOfBed;
		this.roomStatus = roomStatus;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public int getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}

	public int getNumberOfBed() {
		return numberOfBed;
	}

	public void setNumberOfBed(int numberOfBed) {
		this.numberOfBed = numberOfBed;
	}

	public String getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}

}
