package com.revature.employeereimbursementsystem.service;

import com.revature.employeereimbursementsystem.dao.UserRepository;
import com.revature.employeereimbursementsystem.exception.BadParameterException;
import com.revature.employeereimbursementsystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.FailedLoginException;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepo;

    public User login(String username, String password) throws FailedLoginException, BadParameterException {

        // If they didn't input a username or password at all
        if (username.trim().equals("") || password.trim().equals("")) {
            throw new BadParameterException("You must provide a username and password to log in");
        }

        // trim() will trim all leading and trailing whitespace
        User user = userRepo.findByUsernameAndPassword(username.trim(), password.trim());

        // No User in the database matched a particular username and password
        if (user == null) {
            throw new FailedLoginException("Invalid username and/or password");
        }

        return user;
    }

}
