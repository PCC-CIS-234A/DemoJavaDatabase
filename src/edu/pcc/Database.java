package edu.pcc;

import java.sql.*;
import java.util.ArrayList;

public class Database {
    private static final String SERVER = "cisdbss.pcc.edu";
    private static final String DATABASE = "FiredUp";
    private static final String USERNAME = "275student";
    private static final String PASSWORD = "275student";
    private static final String CONNECTION_STRING = "jdbc:jtds:sqlserver://"
            + SERVER + "/" + DATABASE + ";user=" + USERNAME + ";password=" + PASSWORD;
    private Connection mConnection = null;

    private void connect() {
        if(mConnection != null)
            return;
        try {
            mConnection = DriverManager.getConnection(CONNECTION_STRING);
            System.out.println("Connected to database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Customer> getCustomersInState(String state) {
        ArrayList<Customer> customers = new ArrayList<>();

        connect();
        String query = "SELECT Name, StreetAddress, StateProvince FROM CUSTOMER WHERE StateProvince = ?";
        try {
            PreparedStatement stmt = mConnection.prepareStatement(query);
            stmt.setString(1, state);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                Customer c = new Customer(
                        rs.getString("Name"),
                        rs.getString("StreetAddress"),
                        rs.getString("StateProvince")
                );
                customers.add(c);
            }
            return customers;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void close() {
        if(mConnection != null) {
            System.out.println("Closing database connection.");
            try {
                mConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void finalize() {
        close();
    }
}
