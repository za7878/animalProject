package com.human.app.web.Book.Model;

public class DoBookingModel {

	String day1;
	String day2;
	String roomtype;
	public DoBookingModel() {}
	public DoBookingModel(String day1, String day2, String roomtype) {
		this.day1 = day1;
		this.day2 = day2;
		this.roomtype = roomtype;
	}
	public String getDay1() {
		return day1;
	}
	public void setDay1(String day1) {
		this.day1 = day1;
	}
	public String getDay2() {
		return day2;
	}
	public void setDay2(String day2) {
		this.day2 = day2;
	}
	public String getRoomtype() {
		return roomtype;
	}
	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}
}
