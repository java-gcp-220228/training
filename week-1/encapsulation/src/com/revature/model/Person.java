package com.revature.model;

public class Person {

    // Limit access to the fields
    private String firstName;
    private String lastName;
    private int age;

    public Person() {
    }

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    /*
        Getters
     */

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    /*
        Setters
     */
    public void setFirstName(String firstName) {
        if (firstName.matches("[a-zA-Z]+")) {
            this.firstName = firstName;
        } else {
            System.out.println("Invalid first name format");
        }
    }

    public void setLastName(String lastName) {
        if (firstName.matches("[a-zA-Z]+")) { // "The string must have 1 or more characters that match a-z or A-Z"
            this.lastName = lastName;
        } else {
            System.out.println("Invalid last name format. Last name must be a through z (lowercase or capitalized)");
        }
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Invalid age. Age must be >= 0");
        }

    }
}
