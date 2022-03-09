package com.revature.service;

import com.revature.dao.StudentDao;
import com.revature.exception.StudentNotFoundException;
import com.revature.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

public class StudentService {

    private static Logger logger = LoggerFactory.getLogger(StudentService.class);

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

    // Business logic goes inside of this method
    public Student addStudent(Student s) throws SQLException {

        validateStudentInformation(s);

        Student addedStudent = studentDao.addStudent(s);
        return addedStudent;
    }

    // If we are editing a student, we must check first of all if the student exists or not
    public Student editStudent(String id, Student s) throws SQLException, StudentNotFoundException {
        try {
            int studentId = Integer.parseInt(id);

            if (studentDao.getStudentById(studentId) == null) {
                throw new StudentNotFoundException("User is trying to edit a Student that does not exist. Student with id " + studentId
                + " was not found");
            }

            validateStudentInformation(s);

            s.setId(studentId);
            Student editedStudent = studentDao.updateStudent(s);

            return editedStudent;
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("Id provided for student must be a valid int");
        }
    }

    public void validateStudentInformation(Student s) {
        s.setFirstName(s.getFirstName().trim());
        s.setLastName(s.getLastName().trim());

        if (!s.getFirstName().matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("First name must only have alphabetical characters. First name input was " + s.getFirstName());
        }

        if (!s.getLastName().matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Last name must only have alphabetical characters. Last name input was " + s.getLastName());
        }

        if (s.getAge() < 0) {
            throw new IllegalArgumentException("Adding a student with age < 0 is not valid. Age provided was " + s.getAge());
        }
    }
}
