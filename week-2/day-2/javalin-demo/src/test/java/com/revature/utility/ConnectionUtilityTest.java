package com.revature.utility;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class ConnectionUtilityTest {

    @Test
    public void test_getConnection() throws SQLException {
        ConnectionUtility.getConnection(); // If something is wrong with getting a connection,
        // a SQLException will be thrown
        // If any exception occurs inside of a test case, but it is not being handled, then the test automatically
        // fails
    }

}
