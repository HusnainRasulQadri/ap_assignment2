package com.company;

import java.io.FileWriter;
import java.io.IOException;

public class Customer {
	private String username;
	private String password;
	private String name;
	private int age;
	private String passportNumber;

	Customer() {
		name = "";
		age = -1;
		passportNumber = "";
	}
	Customer(String name,int age,String passportNumber) {
		this.name = name;
		this.age = age;
		this.passportNumber = passportNumber;
	}
	String getName() {
		return name;
	}
	int getAge() {
		return age;
	}
	String getPassportNumber() {
		return passportNumber;
	}
	String getUsername() {
		return username;
	}
	void setUsername(String username) {
		this.username = username;
	}
	void setPassword(String password) {
		this.password=password;
	}
	void setName(String name) {
		this.name = name;
	}
	void setAge(int age) {
		this.age = age;
	}
	void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	void display(){
		System.out.println("Username:"+username);
		System.out.println("Password:"+password);
		System.out.println("Name:"+name);
		System.out.println("Age:"+age);
		System.out.println("Passport Number:"+passportNumber);

	}
	static Customer getInstance(String username,String password) {
		String[] usernameResponse = Filehandler.getNthValue("passengers.csv",0,username);
		String[] passwordResponse = Filehandler.getNthValue("passengers.csv",1,password);

		if (usernameResponse[0].equals(passwordResponse[0]) && !usernameResponse.equals(null)) {
			Customer temp = new Customer();
			temp.username = username;
			temp.password = password;
			temp.name = usernameResponse[2];
			temp.age =  Integer.parseInt(usernameResponse[3]);
			temp.passportNumber = usernameResponse[4];
			return temp;
		}
		else {
			return null;
		}
	}
	void storeInstance() throws IOException {
		FileWriter csvWriter = new FileWriter("passengers.csv",true);
		csvWriter.append(username);
		csvWriter.append(",");
		csvWriter.append(password);
		csvWriter.append(",");
		csvWriter.append(name);
		csvWriter.append(",");
		csvWriter.append(Integer.toString(age));
		csvWriter.append(",");
		csvWriter.append(passportNumber);
		csvWriter.append("\n");
		csvWriter.flush();
		csvWriter.close();
	}
}
