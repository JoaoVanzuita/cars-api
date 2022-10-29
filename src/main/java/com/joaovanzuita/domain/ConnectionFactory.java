package com.joaovanzuita.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {

    private static final String URL = "jdbc:postgresql://localhost/cars_api";
    private static final String USER = "cars_api_user";
    private static final String PASSWORD = "cars_api";
    private static final int MAX_CON = 10;

    private static final Connection[] CONNECTIONS = new Connection[MAX_CON];

    public static Connection getConnection(){

        try {
        	Class.forName("org.postgresql.Driver");
        	for (int i = 0; i < MAX_CON; i++) {
                if (CONNECTIONS[i] == null || CONNECTIONS[i].isClosed()) {
                    CONNECTIONS[i] = DriverManager.getConnection(URL, USER, PASSWORD);
                    return CONNECTIONS[i];
                }
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }    
}