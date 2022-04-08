package com.revature.employeereimbursementsystem.integration.dao;

import com.revature.employeereimbursementsystem.dao.UserRepository;
import com.revature.employeereimbursementsystem.model.User;
import com.revature.employeereimbursementsystem.model.UserRole;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest // Will allow for Spring Test to start up an ApplicationContext (name of IoC) container that contains
// all of our spring beans wired up inside of the application
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
// Before each test method runs, it will delete the ApplicationContext and start up a fresh one
// This can helpful if we want to have a fresh database for each test, because each time this happens, a
// new H2 database is also spun up
public class UserRepositoryTest {

//    @Autowired
//    private EntityManager em;

    // This is THE actual UserRepository bean being injected into
    // this test class in order for us to test it
    @Autowired
    private UserRepository userRepo;

    @Test
    @Transactional
    public void test_getUserByUsernameAndPassword_validCredentials() {
        // Arrange
        /*
            We have commented out the code to populate the data into the embedded H2 database
            because we are instead using a data.sql file to execute INSERT queries as initial data
            for testing
         */
//        UserRole employee = new UserRole(); // id 1 (user_role)
//        employee.setRole("employee");
//
//        UserRole manager = new UserRole(); // id 2 (user_role)
//        manager.setRole("finance_manager");
//
//        em.persist(employee);
//        em.persist(manager);
//
//        User user1 = new User(); // id 1 (user)
//        user1.setUsername("bach_tran");
//        user1.setPassword("pass12345");
//        user1.setFirstName("Bach");
//        user1.setLastName("Tran");
//        user1.setEmail("bach_tran@email.com");
//        user1.setRole(manager);
//
//        em.persist(user1);

        // Act
        User actual = userRepo.findByUsernameAndPassword("bach_tran", "password123");

        // Assert
        UserRole expectedUserRole = new UserRole();
        expectedUserRole.setId(1);
        expectedUserRole.setRole("finance_manager");

        User expected = new User();
        expected.setId(1);
        expected.setUsername("bach_tran");
        expected.setPassword("password123");
        expected.setFirstName("Bach");
        expected.setLastName("Tran");
        expected.setEmail("bach_tran@email.com");
        expected.setRole(expectedUserRole);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_getUserByUsernameAndPassword_invalidCredentials() {
        // Act
        User actual = userRepo.findByUsernameAndPassword("invalid", "1234");

        // Assert
        Assertions.assertNull(actual);
    }

    @Test
    public void test_findByFirstName_negative() {
        // Act
        Set<User> actual = userRepo.findByFirstName("Test");

        // Assert
        Set<User> expected = new HashSet<>();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_findByFirstName_positive() {
        // Act
        Set<User> actual = userRepo.findByFirstName("John");

        // Assert
        Set<User> expected = new HashSet<>();

        UserRole employeeRole = new UserRole();
        employeeRole.setId(2);
        employeeRole.setRole("employee");


        User expectedUser1 = new User();
        expectedUser1.setId(3);
        expectedUser1.setUsername("john_doe");
        expectedUser1.setPassword("pass12345");
        expectedUser1.setFirstName("John");
        expectedUser1.setLastName("Doe");
        expectedUser1.setEmail("john_doe@email.com");
        expectedUser1.setRole(employeeRole);

        User expectedUser2 = new User();
        expectedUser2.setId(4);
        expectedUser2.setUsername("john_smith");
        expectedUser2.setPassword("pass123");
        expectedUser2.setFirstName("John");
        expectedUser2.setLastName("Smith");
        expectedUser2.setEmail("john_smith@email.com");
        expectedUser2.setRole(employeeRole);

        expected.add(expectedUser1);
        expected.add(expectedUser2);

        Assertions.assertEquals(expected, actual);
    }

}
