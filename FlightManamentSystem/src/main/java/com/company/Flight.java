package com.company;

import java.io.IOException;

class FileError extends Throwable{
	FileError(String msg){
		super(msg);
	}
}

public class Flight {
	private int id;
	private String plane;
	private String source;
	private String destination;
	private String departureDT;
	private String expectedArrivalDT;
	private int numOfSeatsAvailable;
	private int price;
	private String transit;

	Flight (int id,String plane,String source,String destination,String departureDT, String expectedArrivalDT,int numOfSeatsAvailable,int price,String transit) {
		this.id = id;
		this.plane = plane;
		this.source = source;
		this.destination = destination;
		this.departureDT = departureDT;
		this.expectedArrivalDT = expectedArrivalDT;
		this.numOfSeatsAvailable = numOfSeatsAvailable;
		this.price = price;
		this.transit = transit;
	}
	int getId() {
		return id;
	}
	String getPlane() {
		return plane;
	}
	String getSource() {
		return source;
	}
	String getDestination() {
		return destination;
	}
	String getDepartureDT() {
		return departureDT;
	}
	String getExpectedArrivalDT() {
		return expectedArrivalDT;
	}
	int getNumOfSeatsAvailable(){
		return numOfSeatsAvailable;
	}
	void setId(int id) {
		this.id = id;
	}
	void setPlane(String plane) {
		this.plane = plane;
	}
	void setSource(String source) {
		this.source = source;
	}
	void setDestination(String destination) {
		this.destination = destination;
	}
	void setDepartureDT(String departureDT) {
		this.departureDT = departureDT;
	}
	void setExpectedArrivalDT(String expectedArrivalDT) {
		this.expectedArrivalDT = expectedArrivalDT;
	}
	void setNumOfSeatsAvailable(int numOfSeatsAvailable) {
		this.numOfSeatsAvailable = numOfSeatsAvailable;
	}
	static String[][] getTicketsSrcDes(String source, String destination) throws IOException, FileError {
		String ans[][] = new String[100][9];
		String Sources[][] = Filehandler.getColumn("flights.csv",2,source,0);
		String Destinations[][] = Filehandler.getColumn("flights.csv",3,destination,0);

		int ansCounter = 0;
		for (int i=0;i<100;i++) {
			for (int j=0;j<100;j++) {
				if (Destinations[j][0] != null && Sources[i][0]!=null && Sources[i][0].equals(Destinations[j][0])) {
					ans[ansCounter][0] = Sources[i][0];
					ans[ansCounter][1] = Sources[i][1];
					ans[ansCounter][2] = Sources[i][2];
					ans[ansCounter][3] = Sources[i][3];
					ans[ansCounter][4] = Sources[i][4];
					ans[ansCounter][5] = Sources[i][5];
					ans[ansCounter][6] = Sources[i][6];
					ans[ansCounter][7] = Sources[i][7];
					ans[ansCounter][8] = Sources[i][8];
					ansCounter++;
				}
			}
		}
		return ans;	
	}
	static String[][] getAllFlights() {
		String ans[][] = Filehandler.getAllData("flights.csv");
		return ans;
	}
}
