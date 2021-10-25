package com.company;

import java.io.IOException;
import java.util.Scanner;

class NotProperInput extends Throwable{
	NotProperInput(String msg){
		super(msg);
	}
}

public class UI {
	public static Customer initiate_program() {
		while (true) {
			try {
				System.out.println("Press 1 to Login");
				System.out.println("Press 2 to Sign Up");
				System.out.println("Press 0 to Exit");
				Scanner input = new Scanner(System.in);

				int temp = input.nextInt();
				if (temp == 1) {
					return login();
				} else if (temp == 2) {
					return signUp();
				} else if (temp == 0) {
					return null;
				} else {
					NotProperInput invalid = new NotProperInput("Invalid Input");
					throw invalid;
				}
			} catch (NotProperInput | IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static Customer login() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Username:");
		String username = input.next();
		System.out.print("Enter Password:");
		String password = input.next();
		return Customer.getInstance(username,password);
	}
	public static Customer signUp() throws IOException {
		Customer NewCustomer = new Customer();
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Username:");
		NewCustomer.setUsername(input.next());
		System.out.print("Enter Password:");
		NewCustomer.setPassword(input.next());
		System.out.print("Enter First Name:");
		String name = new String();
		name = input.next();
		System.out.print("Enter Second Name:");
		name += " ";
		name += input.next();
		NewCustomer.setName(name);
		System.out.print("Enter Age:");
		NewCustomer.setAge(input.nextInt());
		System.out.print("Enter Passport Number:");
		NewCustomer.setPassportNumber(input.next());
		NewCustomer.storeInstance();
		return NewCustomer;
	}
	public static void passenger_menu(Customer Object) throws NumberFormatException, IOException, FileError {
		while (true) {
			try {
				System.out.println("Press 1 to buy Ticket");
				System.out.println("Press 2 to book a Ticket");
				System.out.println("Press 3 to print all the available flights and their prices");
				System.out.println("Press 4 to print passenger data");
				System.out.println("Press 5 to cancel ticket");
				System.out.println("Press 6 to exit");

				Scanner input = new Scanner(System.in);
				String source;
				String destination;
				String list[][] = new String[100][];
				int i;
				int choice;
				switch (input.nextInt()) {
					case 1:
						System.out.print("Enter Source (Where you want to fly from):");
						source = input.next();
						System.out.print("Enter Destination (Where you want to go):");
						destination = input.next();
						list = Flight.getTicketsSrcDes(source,destination);
						i=0;
						while (list[i][3] != null) {
							if (i==0) {
								System.out.print("Sr\tID\tPlane\tSource\tDestination\tDeptDT\t\t\tArrivalDT\t\tSeatsAvail\tPrice\tTransit\n");
							}
							System.out.println(i+".\t"+list[i][0]+"\t"+list[i][1]+"\t"+list[i][2]+"\t"+list[i][3]+"\t\t"+list[i][4]+"\t"+list[i][5]+"\t"+list[i][6]+"\t\t"+list[i][7]+"\t"+list[i][8]+"\n");
							i++;
						}
						if (list[0][3] != null) {
							System.out.println("Enter your choice:");
							choice = input.nextInt();
						
							Ticket.ticketPurchase(list[choice][0], Object.getUsername(),Integer.parseInt(list[choice][7]));
						}
						break;
					case 2:
						System.out.print("Enter Source (Where you want to fly from):");
						source = input.next();
						System.out.print("Enter Destination (Where you want to go):");
						destination = input.next();
						list = Flight.getTicketsSrcDes(source,destination);
						i=0;
						while (list[i][3] != null) {
							if (i == 0) {
								System.out.print("Sr\tID\tPlane\tSource\tDestination\tDeptDT\t\t\tArrivalDT\t\tSeatsAvail\tPrice\tTransit\n");
							}
							System.out.println(i+".\t"+list[i][0]+"\t"+list[i][1]+"\t"+list[i][2]+"\t"+list[i][3]+"\t\t"+list[i][4]+"\t"+list[i][5]+"\t"+list[i][6]+"\t\t"+list[i][7]+"\t"+list[i][8]+"\n");
							i++;
						}
						System.out.println("Enter your choice:");
						int choice_2 = input.nextInt();
						
						System.out.println("Enter intial amount that you will pay");
						int downpayment = input.nextInt();
						
						Booking.bookAFlight(list[choice_2][0], Object.getUsername(), downpayment);
						
						break;
					case 3:
						list = Flight.getAllFlights();
						i=0;
						while (list[i][3] != null) {
							if (i==0) {
								System.out.print("Sr\tID\tPlane\tSource\tDestination\tDeptDT\t\t\tArrivalDT\t\tSeatsAvail\tPrice\tTransit\n");
							}
							System.out.println(i+".\t"+list[i][0]+"\t"+list[i][1]+"\t"+list[i][2]+"\t"+list[i][3]+"\t\t"+list[i][4]+"\t"+list[i][5]+"\t"+list[i][6]+"\t\t"+list[i][7]+"\t"+list[i][8]+"\n");
							i++;
						}
						if (list[0][3] != null) {
							System.out.print("Enter your choice to buy ticket (-1 to go back to menu):");
							choice = input.nextInt();
							if (choice != -1) {
								Ticket.ticketPurchase(list[choice][0], Object.getUsername(),Integer.parseInt(list[choice][7]));
							}
						}
						break;
					case 4:
						Object.display();
						break;
					case 5:
						String data[][] = Filehandler.getAllData("tickets.csv");
						int k=0;
						while (data[k][0] != null) {
							if (data[k][1].equals(Object.getUsername())) {
								if (k == 0) {
									System.out.println("FlightNo\tUsername\tCost");
								}
								System.out.println(data[0]+"\t"+data[1]+"\t"+data[2]);
							}
							k++;
						}
						System.out.print("Enter flight id:");
						String id = input.next();
						String toBeDeleted[] = Filehandler.getNthValue("tickets.csv",0, id);
						String delete_this = toBeDeleted[0] + toBeDeleted[1]+ toBeDeleted[2];
						System.out.println(delete_this);
						Filehandler.deleteData("tickets.csv",delete_this);
						break;
					case 6:
						return;
					default:
						NotProperInput invalid = new NotProperInput("Invalid Input");
						throw invalid;
				}
			}
			catch (NotProperInput e) {
				e.printStackTrace();
			}
		}
	}
}
