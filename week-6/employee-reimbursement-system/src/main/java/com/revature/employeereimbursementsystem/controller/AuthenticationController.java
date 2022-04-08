package com.revature.employeereimbursementsystem.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.revature.employeereimbursementsystem.exception.BadParameterException;
import com.revature.employeereimbursementsystem.model.LoginDTO;
import com.revature.employeereimbursementsystem.model.User;
import com.revature.employeereimbursementsystem.model.UserJwtDto;
import com.revature.employeereimbursementsystem.service.AuthenticationService;
import com.revature.employeereimbursementsystem.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.FailedLoginException;

@RestController
@CrossOrigin(originPatterns = "*", exposedHeaders = "*", allowedHeaders = "*")
public class AuthenticationController {

    // types of injection:
    // 1. Field injection
    // 2. Setter injection
    // 3. Constructor injection

    /*
        Field Injection
     */
    @Autowired
    private AuthenticationService authService;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO dto) throws JsonProcessingException {
        try {
            User user = authService.login(dto.getUsername(), dto.getPassword());

            // Utilize JwtService to create a JSON web token with user information inside
            String jwt = jwtService.createJwt(user);

            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.set("token", jwt);

            return ResponseEntity.ok().headers(responseHeaders).body(user);
        } catch (FailedLoginException e) {
            return ResponseEntity.status(401).body(e.getMessage());
        } catch (BadParameterException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @GetMapping("/test")
    public ResponseEntity<String> test(@RequestHeader("Authorization") String headerValue) {
        // Bearer <token>
        String jwt = headerValue.split(" ")[1];

        UserJwtDto dto = null;
        try {
            dto = jwtService.parseJwt(jwt);

            return ResponseEntity.ok(dto.toString());
        } catch (JsonProcessingException e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }

    }

    /*
        Constructor injection
     */
//    @Autowired
//    public AuthenticationController(AuthenticationService authService) {
//        this.authService = authService;
//    }

    /*
        Setter injection
     */
//    @Autowired
//    public void setAuthService(AuthenticationService authService) {
//        this.authService = authService;
//    }
}
