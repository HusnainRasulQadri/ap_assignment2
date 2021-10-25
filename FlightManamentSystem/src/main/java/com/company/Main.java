package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException, FileError {
	    Customer passenger = UI.initiate_program();
	    if (passenger != null) {    
	    	UI.passenger_menu(passenger);
	    }
    }
}
