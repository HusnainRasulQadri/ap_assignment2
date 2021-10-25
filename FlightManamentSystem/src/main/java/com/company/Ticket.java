package com.company;

import java.io.FileWriter;
import java.io.IOException;

public class Ticket {
	private String flight_id;
	private String passenger_username;
	private int price;
	Ticket(String flight_id,String passenger_username,int price) {
		this.flight_id = flight_id;
		this.passenger_username = passenger_username;
		this.price = price;
	}
	String getFlight() {
		return flight_id;
	}
	String getPassenger() {
		return passenger_username;
	}
	int getPrice() {
		return price;
	}
	void setFlight(String flight_id) {
		this.flight_id = flight_id;
	}
	void setPassenger(String passenger_username) {
		this.passenger_username = passenger_username;
	}
	void setPrice(int price) {
		this.price = price;
	}
	static void ticketPurchase(String flight_id,String passenger_username,int price) throws IOException {
		FileWriter csvWriter = new FileWriter("tickets.csv",true);
		csvWriter.append(flight_id);
		csvWriter.append(",");
		csvWriter.append(passenger_username);
		csvWriter.append(",");
		csvWriter.append(Integer.toString(price));
		csvWriter.flush();
		csvWriter.close();
	}
}
