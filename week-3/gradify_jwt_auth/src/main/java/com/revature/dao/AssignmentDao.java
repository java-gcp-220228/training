package com.revature.dao;

import com.revature.dto.AddAssignmentDTO;
import com.revature.model.Assignment;
import com.revature.model.User;
import com.revature.utility.ConnectionUtility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AssignmentDao {

    public Assignment gradeAssignment(int assignmentId, int grade, int graderId) throws SQLException {
        try (Connection con = ConnectionUtility.getConnection()) {
            con.setAutoCommit(false);

            String sql = "UPDATE assignments " +
                    "SET grade = ?, " +
                    "grader_id = ? " +
                    "WHERE id = ?";

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, grade);
            pstmt.setInt(2, graderId);
            pstmt.setInt(3, assignmentId);

            pstmt.executeUpdate();

            String sql2 = "SELECT a.id as assignment_id, a.assignment_name, a.grade, student_user.id as student_id, student_user.username as student_username, student_user.password as student_password, grader_user.id as grader_id, grader_user.username as grader_username, grader_user.password as grader_password " +
                    "FROM assignments a " +
                    "LEFT JOIN users student_user " +
                    "ON student_user.id = a.student_id " +
                    "LEFT JOIN users grader_user " +
                    "ON grader_user.id = a.grader_id " +
                    "WHERE a.id = ?";

            PreparedStatement pstmt2 = con.prepareStatement(sql2);
            pstmt2.setInt(1, assignmentId);

            ResultSet rs2 = pstmt2.executeQuery();

            rs2.next();
            // Assignments
            int aId = rs2.getInt("assignment_id");
            String assignmentName = rs2.getString("assignment_name");
            int gr = rs2.getInt("grade");

            // Student User
            int studentId = rs2.getInt("student_id");
            String studentUsername = rs2.getString("student_username");
            String studentPassword = rs2.getString("student_password");
            String studentRole = "student";

            User student = new User(studentId, studentUsername, studentPassword, studentRole);

            // Trainer User
            int gId = rs2.getInt("grader_id");
            String graderUsername = rs2.getString("grader_username");
            String graderPassword = rs2.getString("grader_password");
            String graderRole = "trainer";

            User trainer = new User(gId, graderUsername, graderPassword, graderRole);

            Assignment a = new Assignment(aId, assignmentName, gr, student, trainer);

            con.commit();
            return a;
        }
    }

    public Assignment addAssignment(int studentId, AddAssignmentDTO dto) throws SQLException {
        try (Connection con = ConnectionUtility.getConnection()) {
            con.setAutoCommit(false); // We could set autocommit to false, and at the end, commit the changes

            String sql = "INSERT INTO assignments (assignment_name, student_id) " +
                    "VALUES (?, ?)";

            PreparedStatement pstmt1 = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt1.setString(1, dto.getAssignmentName());
            pstmt1.setInt(2, studentId);
            pstmt1.executeUpdate();

            ResultSet rs = pstmt1.getGeneratedKeys();
            rs.next();
            int assignmentId = rs.getInt(1); // Our automatically generated id

            String sql2 = "SELECT * FROM users WHERE id = ?";
            PreparedStatement pstmt2 = con.prepareStatement(sql2);
            pstmt2.setInt(1, studentId);

            ResultSet rs2 = pstmt2.executeQuery();
            rs2.next();
            int sId = rs2.getInt("id");
            String studentUsername = rs2.getString("username");
            String studentPassword = rs2.getString("password");
            String studentRole = "student";

            User student = new User(sId, studentUsername, studentPassword, studentRole);

            Assignment assignment = new Assignment(assignmentId, dto.getAssignmentName(), 0, student, null);

            con.commit(); // commit the transaction

            return assignment;
        }
    }

    public List<Assignment> getAllAssignments() throws SQLException {
        try (Connection con = ConnectionUtility.getConnection()) {
            List<Assignment> assignments = new ArrayList<>();

            String sql = "SELECT assignments.id as assignment_id, assignment_name, grade, student_user.id as student_id, student_user.username as student_username, student_user.password as student_password, grader_user.id as grader_id, grader_user.username as grader_username, grader_user.password as grader_password " +
                    "FROM assignments " +
                    "LEFT JOIN users student_user " +
                    "ON student_user.id = assignments.student_id " +
                    "LEFT JOIN users grader_user " +
                    "ON grader_user.id = assignments.grader_id";

            PreparedStatement pstmt = con.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // Assignments
                int assignmentId = rs.getInt("assignment_id");
                String assignmentName = rs.getString("assignment_name");
                int grade = rs.getInt("grade");

                // Student User
                int studentId = rs.getInt("student_id");
                String studentUsername = rs.getString("student_username");
                String studentPassword = rs.getString("student_password");
                String studentRole = "student";

                User student = new User(studentId, studentUsername, studentPassword, studentRole);

                // Trainer User
                int graderId = rs.getInt("grader_id");
                String graderUsername = rs.getString("grader_username");
                String graderPassword = rs.getString("grader_password");
                String graderRole = "trainer";

                User trainer = new User(graderId, graderUsername, graderPassword, graderRole);

                Assignment a = new Assignment(assignmentId, assignmentName, grade, student, trainer);

                assignments.add(a);
            }

            return assignments;
        }
    }

        public List<Assignment> getAllAssignmentsByUserId (int userId) throws SQLException {
            try (Connection con = ConnectionUtility.getConnection()) {
                List<Assignment> assignments = new ArrayList<>();

                String sql = "SELECT a.id as assignment_id, assignment_name, grade, student_user.id as student_id, student_user.username as student_username, student_user.password as student_password, grader_user.id as grader_id, grader_user.username as grader_username, grader_user.password as grader_password " +
                        "FROM assignments a " +
                        "LEFT JOIN users student_user " +
                        "ON student_user.id = a.student_id " +
                        "LEFT JOIN users grader_user " +
                        "ON grader_user.id = a.grader_id " +
                        "WHERE a.student_id = ?";

                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setInt(1, userId);

                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    // Assignments
                    int assignmentId = rs.getInt("assignment_id");
                    String assignmentName = rs.getString("assignment_name");
                    int grade = rs.getInt("grade");

                    // Student User
                    int studentId = rs.getInt("student_id");
                    String studentUsername = rs.getString("student_username");
                    String studentPassword = rs.getString("student_password");
                    String studentRole = "student";

                    User student = new User(studentId, studentUsername, studentPassword, studentRole);

                    // Trainer User
                    int graderId = rs.getInt("grader_id");
                    String graderUsername = rs.getString("grader_username");
                    String graderPassword = rs.getString("grader_password");
                    String graderRole = "trainer";

                    User trainer = new User(graderId, graderUsername, graderPassword, graderRole);

                    Assignment a = new Assignment(assignmentId, assignmentName, grade, student, trainer);

                    assignments.add(a);
                }

                return assignments;
            }
        }

    }
