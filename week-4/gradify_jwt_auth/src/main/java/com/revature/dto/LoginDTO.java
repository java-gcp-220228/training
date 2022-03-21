package com.revature.dto;

// DTO stands for Data Transfer Object
// Its purpose is to pass data around in the form of an object
// In this case, we create a class called LoginDTO so that it can pass around username and password information
public class LoginDTO {

    private String username;
    private String password;

    public LoginDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
