package com.revature.service;

import com.revature.dao.StudentDao;
import com.revature.exception.StudentNotFoundException;
import com.revature.model.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StudentServiceTest {

    // Positive (happy path)
    @Test
    public void testGetAllStudents() throws SQLException {
        // Arrange
        StudentDao mockedObject = mock(StudentDao.class);

        List<Student> fakeStudents = new ArrayList<>();
        fakeStudents.add(new Student(1, "Bill", "Smith", 20));
        fakeStudents.add(new Student(2, "Test", "Test123", 15));
        fakeStudents.add(new Student(3, "John", "Doe", 30));

        // Whenever the code in the Service layer calls the getAllStudents() method
        // for the dao layer, then return the list of students
        // we have specified above
        when(mockedObject.getAllStudents()).thenReturn(fakeStudents);

        StudentService studentService = new StudentService(mockedObject);

        // Act
        List<Student> actual = studentService.getAllStudents();

        // Assert
        List<Student> expected = new ArrayList<>(fakeStudents);
        Assertions.assertEquals(expected, actual);
    }

    // Positive test is also known as the
    // "Happy path"
    // The "user" is utilizing this method correctly
    @Test
    public void testGetStudentById_positiveTest() throws SQLException, StudentNotFoundException {
        // Arrange
        StudentDao mockDao = mock(StudentDao.class);

        // Mocking the return value for id 10
        when(mockDao.getStudentById(eq(10))).thenReturn(
                new Student(10, "Test", "Testy", 20)
        );

        StudentService studentService = new StudentService(mockDao);

        // Act
        Student actual = studentService.getStudentById("10");

        // Assert
        Student expected = new Student(10, "Test", "Testy", 20);
        Assertions.assertEquals(expected, actual);
    }

    // Negative test
    @Test
    public void test_getStudentById_studentDoesNotExist() throws SQLException, StudentNotFoundException {
        // Arrange
        StudentDao mockDao = mock(StudentDao.class);

        StudentService studentService = new StudentService(mockDao);

        // Act + Assert

        // The test case will pass if we encounter this exception
        // (StudentNotFoundException)
        Assertions.assertThrows(StudentNotFoundException.class, () -> {
            studentService.getStudentById("10");
        });
    }

    // Negative test
    @Test
    public void test_getStudentById_invalidId() throws SQLException, StudentNotFoundException {
        // Arrange
        StudentDao mockDao = mock(StudentDao.class);

        StudentService studentService = new StudentService(mockDao);

        // Act
        try {
            studentService.getStudentById("abc");

            fail(); // We only reach this line if no exception is caught
        } catch(IllegalArgumentException e) {
            String expectedMessage = "Id provided for student must be a valid int";
            String actualMessage = e.getMessage();

            Assertions.assertEquals(expectedMessage, actualMessage);
        }
    }

    // Negative
    @Test
    public void test_getStudentById_sqlExceptionFromDao() throws SQLException {
        // Arrange
        StudentDao mockDao = mock(StudentDao.class);

        when(mockDao.getStudentById(anyInt())).thenThrow(SQLException.class);

        StudentService studentService = new StudentService(mockDao);

        // Act + Assert
        Assertions.assertThrows(SQLException.class, () -> {
           studentService.getStudentById("5");
        });
    }
}
