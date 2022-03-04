package com.revature.dao;

import com.revature.model.Student;
import com.revature.utility.ConnectionUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Dao stands for "data access object"
// The purpose of this class is to provide code that interacts with the database
// Typically, as a guide, you will be following CRUD operations in your dao
public class StudentDao {

    public Student getStudentById(int id) throws SQLException {
        try (Connection con = ConnectionUtility.getConnection()) {
            String query = "SELECT * FROM students WHERE id = ?"; // ? is a placeholder for a parameter

            PreparedStatement pstmt = con.prepareStatement(query);

            // Set the ? to some value
            pstmt.setInt(1, id); // 1st question mark

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int studentId = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                int age = rs.getInt("age");

                return new Student(studentId, firstName, lastName, age);
            }
        }

        return null;
    }

    public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();

        // "try-with-resources"
        // If you have an object that implements the "Closeable" interface
        // putting that resource into the try with resources block will automatically
        // call the close() method on when that block is finished executing (or an exception occurs
        // while inside of that block)
        try (Connection con = ConnectionUtility.getConnection()) {
            String query = "SELECT * FROM students";

            PreparedStatement pstmt = con.prepareStatement(query);

            // Execute the query and retrieve a ResultSet
            // A ResultSet is a pointer to the database that allows us to
            // grab results from the database
            // It doesn't actually contain the data inside of it, it just retrieves the
            // data as we use the ResultSet object
            ResultSet rs = pstmt.executeQuery();

            // rs.next() returns a boolean, which is true if it successfully retrieved another
            // record
            while(rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                int age = rs.getInt("age");

                Student student = new Student(id, firstName, lastName, age);
                students.add(student); // Add to our List
            }
        }

        return students;
    }

}
