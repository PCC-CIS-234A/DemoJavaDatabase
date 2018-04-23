package edu.pcc;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        /*
        Normally, would just set up and display a GUI here, but since this is just a demo of talking to the database,
        we'll just treat this as the presentation layer.
        */
        ArrayList<Customer> customers = Customer.getCustomersInState("OR");
        for (Customer c: customers) {
            System.out.println(c.getName() + ": " + c.getStreetAddress() + ", " + c.getStateProvince());
        }
    }
}
