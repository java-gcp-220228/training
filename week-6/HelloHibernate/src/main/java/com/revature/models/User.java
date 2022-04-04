package com.revature.models;


import javax.persistence.*;

@Entity //tells Hibernate that this is a table
@Table(name="ers_users") //optional, but allows us to define our table like we want
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrements
    @Column(name="user_id")
    private int id;

    @Column(name="user_firstname", nullable = false)
    private String firstName;

    @Column(name="user_lastname", nullable = false)
    private String lastName;

    @Column(name="username", unique = true, length = 50, nullable = false)
    private String username;

    @Column(name="password", length = 50, nullable = false)
    private String password;

    public User() {
    }

    public User(String firstName, String lastName, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    public User(int id, String firstName, String lastName, String username, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
