package com.revature.utility;

import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// TODO 2: Create a ConnectionUtility class that will contain the getConnection method where our code will belong
public class ConnectionUtility {

    public static Connection getConnection() throws SQLException {
        // TODO 3: Grab the connection string (url), username, password for the database
        // Preferably, this will be from environment variables
        String url = System.getenv("db_url");
        String username = System.getenv("db_username");
        String password = System.getenv("db_password");

        // TODO 4: Register the Postgres driver with the DriverManager
        DriverManager.registerDriver(new Driver());

        // TODO 5: Get the Connection object from the DriverManager
        Connection connection = DriverManager.getConnection(url, username, password);

        return connection;
    }

}
