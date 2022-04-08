package com.revature.employeereimbursementsystem.integration.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.employeereimbursementsystem.model.LoginDTO;
import com.revature.employeereimbursementsystem.model.User;
import com.revature.employeereimbursementsystem.model.UserRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.print.attribute.standard.Media;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest // Spring test
@AutoConfigureMockMvc // Spring test
public class AuthenticationControllerTest {

    // MockMvc provides a way to send mock requests to the Spring boot application
    // it is part of Spring test, which is a module that provides a bunch of testing utilities
    // especially those for performing integration testing
    @Autowired
    private MockMvc mockMvc;

//    @Autowired
//    private AuthenticationController authController;

    @Test
    public void test_loginEndpoint_positive() throws Exception {
        LoginDTO dto = new LoginDTO();
        dto.setUsername("bach_tran");
        dto.setPassword("password123");
        String jsonDto = (new ObjectMapper()).writeValueAsString(dto);

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

        String expectedJson = (new ObjectMapper()).writeValueAsString(expected);

        this.mockMvc.perform(
                        post("/login").
                        contentType(MediaType.APPLICATION_JSON).
                        content(jsonDto))
                .andExpect(status().is(200)) // 200 status code
                .andExpect(content().json(expectedJson)) // User object as JSON in the response body
                // token response header contains the correct JWT
                .andExpect(header().string("token", "eyJhbGciOiJIUzUxMiJ9.eyJ1c2VyX2R0byI6IntcInVzZXJJZFwiOjEsXCJmaXJzdE5hbWVcIjpcIkJhY2hcIixcImxhc3ROYW1lXCI6XCJUcmFuXCIsXCJ1c2VyUm9sZVwiOlwiZmluYW5jZV9tYW5hZ2VyXCIsXCJ1c2VybmFtZVwiOlwiYmFjaF90cmFuXCIsXCJlbWFpbFwiOlwiYmFjaF90cmFuQGVtYWlsLmNvbVwifSJ9.kMn4M1si4pJgqNsqZNEF6soM2AfHmAtWiS_TmqDq5PG2sREIi8NWTW_2CWj8JJcJLaMwnXVCyFYjQoaVnmkghQ"));
    }

    @Test
    public void test_loginEndpoint_invalidCredentials() throws Exception {
        LoginDTO dto = new LoginDTO();
        dto.setUsername("invalid");
        dto.setPassword("invalid");
        String jsonDto = (new ObjectMapper()).writeValueAsString(dto);

        this.mockMvc.perform(post("/login").contentType(MediaType.APPLICATION_JSON).content(jsonDto))
                .andExpect(status().is(401))
                .andExpect(content().string("Invalid username and/or password"));
    }

    @Test
    public void test_loginEndpoint_blankOrWhitespaceUsernameAndPassword() throws Exception {
        LoginDTO dto = new LoginDTO();
        dto.setUsername("    ");
        dto.setPassword("");
        String jsonDto = (new ObjectMapper()).writeValueAsString(dto);

        this.mockMvc.perform(post("/login").contentType(MediaType.APPLICATION_JSON).content(jsonDto))
                .andExpect(status().is(400))
                .andExpect(content().string("You must provide a username and password to log in"));
    }

}
