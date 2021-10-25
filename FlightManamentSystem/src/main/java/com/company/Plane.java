package com.company;

public class Plane {
	private int numOfSeats;
	private String code;
	private String manufacturerName;
	int getNumOfSeats() {
		return numOfSeats;
	}
	String getCode() {
		return code;
	}
	String getManufacturerName() {
		return manufacturerName;
	}
	void setNumOfSeats(int numOfSeats) {
		this.numOfSeats = numOfSeats;
	}
	void setCode(String code) {
		this.code = code;
	}
	void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}
}
