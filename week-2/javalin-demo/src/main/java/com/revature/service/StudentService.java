package com.revature.service;

import com.revature.dao.StudentDao;
import com.revature.exception.StudentNotFoundException;
import com.revature.model.Student;

import java.sql.SQLException;
import java.util.List;

public class StudentService {

    private StudentDao studentDao;

    public StudentService() {
        this.studentDao = new StudentDao();
    }

    public StudentService(StudentDao mockDao) {
        this.studentDao = mockDao;
    }

    public List<Student> getAllStudents() throws SQLException {
        return this.studentDao.getAllStudents();
    }

    public Student getStudentById(String id) throws SQLException, StudentNotFoundException {
        try {
            int studentId = Integer.parseInt(id); // This could throw an unchecked exception
            // known as NumberFormatException
            // Important to take note of this, because any unhandled exceptions will result
            // in a 500 Internal Server Error (which we should try to avoid)

            Student s = studentDao.getStudentById(studentId); // this could return null

            if (s == null) {
                throw new StudentNotFoundException("Student with id " + studentId + " was not found");
            }

            return s;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Id provided for student must be a valid int");
        }
    }
}
