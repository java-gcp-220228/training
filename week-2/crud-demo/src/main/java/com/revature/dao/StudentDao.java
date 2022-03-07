package com.revature.dao;

import com.revature.model.Student;
import com.revature.utility.ConnectionUtility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// TODO 6: Create a Dao (data access object) class for a particular "entity"
public class StudentDao {

    // TODO 8: Create the methods for the "CRUD" operations

    // C

    // Whenever you add a student, no id is associated yet
    // The id is automatically generated
    // So what we want to do is retrieve an id and return that with the Student object
    public Student addStudent(Student student) throws SQLException {
        try (Connection con = ConnectionUtility.getConnection()) {
            String sql = "INSERT INTO students (first_name, last_name, age) VALUES (?, ?, ?)";

            PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, student.getFirstName());
            pstmt.setString(2, student.getLastName());
            pstmt.setInt(3, student.getAge());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            rs.next();
            int generatedId = rs.getInt(1); // 1st column of the ResultSet

            return new Student(generatedId, student.getFirstName(), student.getLastName(), student.getAge());
        }
    }

    // R
    public Student getStudentById(int id) throws SQLException {
        // TODO 9: Call the getConnection method from ConnectionUtility (which we made)
        try (Connection con = ConnectionUtility.getConnection()) { // try-with-resources
            // TODO 10: Create a (Prepared)Statement object using the Connection object
            String sql = "SELECT * FROM students WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);

            // TODO 11: If any parameters need to be set, set the parameters (?)
            pstmt.setInt(1, id);

            // TODO 12: Execute the query and retrieve a ResultSet object
            ResultSet rs = pstmt.executeQuery(); // executeQuery() is used with SELECT

            // TODO 13: Iterate over record(s) using the ResultSet's next() method
            if (rs.next()) {
                // TODO 14: Grab the information from the record
//                int studentId = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                int age = rs.getInt("age");

                return new Student(id, firstName, lastName, age);
            }

        }

        return null;
    }

    public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();

        try (Connection con = ConnectionUtility.getConnection()) { // try-with-resources
            String sql = "SELECT * FROM students";
            PreparedStatement pstmt = con.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery(); // executeQuery() is used with SELECT

            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                int age = rs.getInt("age");

                students.add(new Student(id, firstName, lastName, age));
            }

        }

        return students;
    }

    // U
    public Student updateStudent(Student student) throws SQLException {
        try (Connection con = ConnectionUtility.getConnection()) {
            String sql = "UPDATE students " +
                    "SET first_name = ?, " +
                    "last_name = ?, " +
                    "age = ? " +
                    "WHERE id = ?";

            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setString(1, student.getFirstName());
            pstmt.setString(2, student.getLastName());
            pstmt.setInt(3, student.getAge());
            pstmt.setInt(4, student.getId());

            pstmt.executeUpdate();
        }

        return student;
    }

    // D
    // true if a record was deleted, false if a record was not deleted
    public boolean deleteStudentById(int id) throws SQLException {
        try (Connection con = ConnectionUtility.getConnection()) {
            String sql = "DELETE FROM students WHERE id = ?";

            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, id);

            int numberOfRecordsDeleted = pstmt.executeUpdate(); // executeUpdate() is used with INSERT, UPDATE, DELETE

            if (numberOfRecordsDeleted == 1) {
                return true;
            }
        }

        return false;
    }
}
