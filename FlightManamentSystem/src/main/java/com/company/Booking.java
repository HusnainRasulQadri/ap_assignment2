package com.company;

import java.io.FileWriter;
import java.io.IOException;

public class Booking {
	private String flight_id;
	private String passenger_username;
	private int downPayment;
	Booking(String flight_id,String passenger_username,int downPayment) {
		this.flight_id = flight_id;
		this.passenger_username = passenger_username;
		this.downPayment = downPayment;
	}
	String getFlight() {
		return flight_id;
	}
	String getPassenger() {
		return passenger_username;
	}
	int getDownPayment() {
		return downPayment;
	}
	void setFlight(String flight_id) {
		this.flight_id = flight_id;
	}
	void setPassenger(String passenger_username) {
		this.passenger_username = passenger_username;
	}
	void setDownPayment(int downPayment) {
		this.downPayment = downPayment;
	}
	static void bookAFlight(String flight_id,String passenger_username,int downpayment) throws IOException {
		FileWriter csvWriter = new FileWriter("bookings.csv",true);
		csvWriter.append(flight_id);
		csvWriter.append(",");
		csvWriter.append(passenger_username);
		csvWriter.append(",");
		csvWriter.append(Integer.toString(downpayment));
		csvWriter.append("\n");
		csvWriter.flush();
		csvWriter.close();
	
	}
}
