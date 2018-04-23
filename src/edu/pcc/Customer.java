package edu.pcc;

import java.util.ArrayList;

/* Example business logic class to hold customer information */
public class Customer {
    private String mName;
    private String mStreetAddress;
    private String mStateProvince;

    /* constructor */
    Customer(String name, String streetAddress, String stateProvince) {
        mName = name;
        mStreetAddress = streetAddress;
        mStateProvince = stateProvince;
    }

    /* getters */
    public String getName() {
        return mName;
    }
    public String getStreetAddress() {
        return mStreetAddress;
    }
    public String getStateProvince() {
        return mStateProvince;
    }

    /* setters */
    public void setName(String name) {
        mName = name;
    }
    public void setStreetAddress(String address) {
        mStreetAddress = address;
    }
    public void setStateProvince(String stateProvince) {
        mStateProvince = stateProvince;
    }

    /* business logic methods */
    public static ArrayList<Customer> getCustomersInState(String state) {
        /* This method is just a pass through so that the presentation layer doesn't have to talk directly to the data layer */
        Database db = new Database();
        return db.getCustomersInState(state);
    }
}
