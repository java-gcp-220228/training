package com.revature.employeereimbursementsystem.integration.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.employeereimbursementsystem.integration.IntegrationTestRunner;
import com.revature.employeereimbursementsystem.model.LoginDTO;
import com.revature.employeereimbursementsystem.model.User;
import com.revature.employeereimbursementsystem.model.UserRole;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// Below annotations are for Spring integration testing purposes
@CucumberContextConfiguration
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)// Restart the ApplicationContext
// which will allow us to have an empty H2 database for each test scenario
// Each test scenario is considered as its own test class (that just happen to use the same AuthenticationControllerTest
// class)
// A new IoC container is created for each test scenario
public class AuthenticationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EntityManager em;

    private ResultActions resultActions;

    @Given("There are users in the database")
    @Transactional
    public void there_are_users_in_the_database() {

        UserRole financeManager = new UserRole();
        financeManager.setRole("finance_manager");

        this.em.persist(financeManager);

        UserRole employee = new UserRole();
        employee.setRole("employee");

        this.em.persist(employee);

        User user1 = new User();
        user1.setEmail("bach_tran@email.com");
        user1.setUsername("bach_tran");
        user1.setPassword("password12345");
        user1.setRole(financeManager);
        user1.setFirstName("Bach");
        user1.setLastName("Tran");

        this.em.persist(user1);

        User user2 = new User();
        user2.setEmail("jane_doe@email.com");
        user2.setUsername("jane_doe");
        user2.setPassword("12345");
        user2.setRole(employee);
        user2.setFirstName("Jane");
        user2.setLastName("Doe");

        this.em.persist(user2);

        this.em.flush(); // Flush changes into the database
    }

    @When("I send a POST request to \\/login with valid username {string} and valid password {string}")
    public void i_send_a_post_request_to_login_with_valid_username_and_valid_password(String username, String password) throws Exception {
        LoginDTO loginDto = new LoginDTO();
        loginDto.setUsername(username);
        loginDto.setPassword(password);
        String loginDtoJsonString = (new ObjectMapper()).writeValueAsString(loginDto);

        this.resultActions = this.mockMvc
                .perform(post("/login").contentType(MediaType.APPLICATION_JSON).content(loginDtoJsonString));
    }

    @Then("I should receive a response with status code {int}, the appropriate User object for bach_tran, and a valid JWT {string}")
    public void i_should_receive_a_response_with_status_code_the_appropriate_user_object_for_bach_tran_and_a_valid_jwt(Integer statusCode, String JWT) throws Exception {

        UserRole expectedUserRole = new UserRole();
        expectedUserRole.setRole("finance_manager");
        expectedUserRole.setId(1);

        User expectedUser = new User();
        expectedUser.setEmail("bach_tran@email.com");
        expectedUser.setUsername("bach_tran");
        expectedUser.setPassword("password12345");
        expectedUser.setRole(expectedUserRole);
        expectedUser.setFirstName("Bach");
        expectedUser.setLastName("Tran");
        expectedUser.setId(1);

        String expectedUserJson = (new ObjectMapper()).writeValueAsString(expectedUser);

        this.resultActions.andExpect(status().is(statusCode))
                .andExpect(content().json(expectedUserJson))
                .andExpect(header().string("token", JWT));
    }

    @Then("I should receive a response with status code {int}, the appropriate User object for jane_doe, and a valid JWT {string}")
    public void i_should_receive_a_response_with_status_code_the_appropriate_user_object_for_jane_doe_and_a_valid_jwt(Integer statusCode, String JWT) throws Exception {
        UserRole expectedUserRole = new UserRole();
        expectedUserRole.setRole("employee");
        expectedUserRole.setId(2);

        User expectedUser = new User();
        expectedUser.setEmail("jane_doe@email.com");
        expectedUser.setUsername("jane_doe");
        expectedUser.setPassword("12345");
        expectedUser.setRole(expectedUserRole);
        expectedUser.setFirstName("Jane");
        expectedUser.setLastName("Doe");
        expectedUser.setId(2);

        String expectedUserJson = (new ObjectMapper()).writeValueAsString(expectedUser);

        this.resultActions.andExpect(status().is(statusCode))
                .andExpect(content().json(expectedUserJson))
                .andExpect(header().string("token", JWT));
    }

}
