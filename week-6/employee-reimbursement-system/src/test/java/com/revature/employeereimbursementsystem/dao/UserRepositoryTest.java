package com.revature.employeereimbursementsystem.dao;

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

@SpringBootTest // Will allow for Spring Test to start up an ApplicationContext (name of IoC) container that contains
// all of our spring beans wired up inside of the application
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
// Before each test method runs, it will delete the ApplicationContext and start up a fresh one
// This can helpful if we want to have a fresh database for each test, because each time this happens, a
// new H2 database is also spun up
@ActiveProfiles("test")
public class UserRepositoryTest {

    @Autowired
    private EntityManager em;

    @Autowired
    private UserRepository userRepo;

    @Test
    @Transactional
    public void test_getUserByUsernameAndPassword_validCredentials() {
        // Arrange
        UserRole employee = new UserRole(); // id 1 (user_role)
        employee.setRole("employee");

        UserRole manager = new UserRole(); // id 2 (user_role)
        manager.setRole("finance_manager");

        em.persist(employee);
        em.persist(manager);

        User user1 = new User(); // id 1 (user)
        user1.setUsername("bach_tran");
        user1.setPassword("pass12345");
        user1.setFirstName("Bach");
        user1.setLastName("Tran");
        user1.setEmail("bach_tran@email.com");
        user1.setRole(manager);

        em.persist(user1);

        // Act
        User actual = userRepo.findByUsernameAndPassword("bach_tran", "pass12345");

        // Assert
        UserRole expectedUserRole = new UserRole();
        expectedUserRole.setId(2);
        expectedUserRole.setRole("finance_manager");

        User expected = new User();
        expected.setId(1);
        expected.setUsername("bach_tran");
        expected.setPassword("pass12345");
        expected.setFirstName("Bach");
        expected.setLastName("Tran");
        expected.setEmail("bach_tran@email.com");
        expected.setRole(expectedUserRole);

        Assertions.assertEquals(expected, actual);
    }

}
