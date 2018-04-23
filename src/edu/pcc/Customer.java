package edu.pcc;

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
}
