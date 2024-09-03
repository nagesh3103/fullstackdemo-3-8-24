package com.neoteric.fullstackdemo_38._4.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection == null) {
                System.out.println("getting Connection");
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://@localhost:3306/bank", "root", "Raja123");

            } else {
                System.out.println("Returning existing connection");
            }
        } catch (Exception e) {
            System.out.println("Exception occurred in getConnection" + e);
        }
        return connection;
    }
}
