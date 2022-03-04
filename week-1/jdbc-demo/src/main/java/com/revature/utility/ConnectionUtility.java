package com.revature.utility;

import org.postgresql.Driver;

import java.sql.Connection; // JDBC interface from the java.sql package
import java.sql.DriverManager; // JDBC class from the java.sql package
import java.sql.SQLException;

public class ConnectionUtility {

    private ConnectionUtility() {
    }

    public static Connection getConnection() throws SQLException {

        // Register the Postgres driver with JDBC
        DriverManager.registerDriver(new Driver());

        // Specify credentials for the database
        String url = System.getenv("db_url");
        String username = System.getenv("db_user");
        String password = System.getenv("db_password");

        Connection connection = DriverManager.getConnection(url, username, password);

        return connection;
    }

}
