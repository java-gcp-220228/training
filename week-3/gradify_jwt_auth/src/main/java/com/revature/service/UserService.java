package com.revature.service;

import com.revature.dao.UserDao;
import com.revature.model.User;

import javax.security.auth.login.FailedLoginException;
import java.sql.SQLException;

public class UserService {

    private UserDao userDao;

    public UserService() {
        this.userDao = new UserDao();
    }

    public UserService(UserDao mockDao) {
        this.userDao = mockDao;
    }

    public User login(String username, String password) throws SQLException, FailedLoginException {
        User user = this.userDao.getUserByUsernameAndPassword(username, password);

        if (user == null) {
            throw new FailedLoginException("Invalid username and/or password was provided");
        }

        return user;
    }

}
