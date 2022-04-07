package com.revature.employeereimbursementsystem.unit.service;

import com.revature.employeereimbursementsystem.dao.UserRepository;
import com.revature.employeereimbursementsystem.exception.BadParameterException;
import com.revature.employeereimbursementsystem.model.User;
import com.revature.employeereimbursementsystem.model.UserRole;
import com.revature.employeereimbursementsystem.service.AuthenticationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.security.auth.login.FailedLoginException;

import java.util.concurrent.TimeUnit;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

// @SpringBootTest is used to primarily perform integration testing
// It will start up an entire IoC container (ApplicationContext) that contains the Spring beans
// for our application
// Here we don't use @SpringBootTest because we don't want to slow down our unit testing
@ExtendWith(MockitoExtension.class) // Provide additional functionality coming from Mockito
// such as using the @Mock and @InjectMocks annotations
public class AuthenticationServiceTest {

    @Mock
    // 1. Mocks UserRepository (fake object)
    private UserRepository userRepo;

    @InjectMocks
    // 1. Instantiate the object
    // 2. Inject any object labelled with @Mock into this object
    private AuthenticationService authService;

    // login method
    // 2 inputs: Username + Password
    // positive test case:
    //      return a user object based on the username and password being correct
    // positive test case:
    //      valid username and password, but user has whitespace before and after
    //      return a user object based on the "stripped" whitespace
    // negative test case:
    //      invalid username and/or password
    //      throw an InvalidLoginException
    // negative test case:
    //      blank username and password (or just all whitespace)
    //      throw a BadParameterException
    // negative test case:
    //      takes more than 5 seconds to execute the login method

    @Test
    @Timeout(value = 5000, unit = TimeUnit.MILLISECONDS)
    public void test_login_positive_validUsernameAndPassword_noWhitespace() throws FailedLoginException, BadParameterException {
        /*
            AAA:
            - Arrange
            - Act
            - Assert
         */

        // Arrange
        User fakeUser = new User();
        fakeUser.setId(100);
        fakeUser.setUsername("correctusername");
        fakeUser.setPassword("correctpassword");
        fakeUser.setFirstName("test");
        fakeUser.setLastName("testy");
        UserRole e = new UserRole();
        e.setId(1);
        e.setRole("finance_manager");
        fakeUser.setRole(e);

        when(userRepo.findByUsernameAndPassword(eq("correctusername"), eq("correctpassword"))).thenReturn(
                fakeUser
        );

        // Act
        User actual = authService.login("correctusername", "correctpassword");

        // Assert
        User expected = new User();
        expected.setId(100);
        expected.setUsername("correctusername");
        expected.setPassword("correctpassword");
        expected.setFirstName("test");
        expected.setLastName("testy");
        UserRole employee = new UserRole();
        employee.setId(1);
        employee.setRole("finance_manager");
        expected.setRole(employee);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Timeout(value = 5000, unit = TimeUnit.MILLISECONDS)
    public void test_login_positive_validUsernameAndPassword_whitespace() throws FailedLoginException, BadParameterException {
        // Arrange
        User fakeUser = new User();
        fakeUser.setId(100);
        fakeUser.setUsername("correctusername");
        fakeUser.setPassword("correctpassword");
        fakeUser.setFirstName("test");
        fakeUser.setLastName("testy");
        UserRole e = new UserRole();
        e.setId(1);
        e.setRole("finance_manager");
        fakeUser.setRole(e);

        when(userRepo.findByUsernameAndPassword(eq("correctusername"), eq("correctpassword"))).thenReturn(
                fakeUser
        );

        // Act
        User actual = authService.login("     correctusername    ", "   correctpassword       ");

        // Assert
        User expected = new User();
        expected.setId(100);
        expected.setUsername("correctusername");
        expected.setPassword("correctpassword");
        expected.setFirstName("test");
        expected.setLastName("testy");
        UserRole employee = new UserRole();
        employee.setId(1);
        employee.setRole("finance_manager");
        expected.setRole(employee);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Timeout(value = 5000, unit = TimeUnit.MILLISECONDS)
    public void test_login_invalidUsernameAndPassword() throws FailedLoginException {
        // Arrange

        // Act + Assert

        Assertions.assertThrows(FailedLoginException.class, () -> {
            authService.login("invalid", "invalid");
        });
    }

    @Test
    @Timeout(value = 5000, unit = TimeUnit.MILLISECONDS)
    public void test_login_allWhitespaceOrBlank() {
        // Act + Assert
        Assertions.assertThrows(BadParameterException.class, () -> {
            authService.login("    ", "");
        });
    }

}
