package com.revature.model;

// The Person class defines 3 properties and 1 behavior
// that objects constructed from this blueprint should have
public class Person {

    public String firstName;
    public String lastName;
    public int age;

    // Constructor #1
    public Person() {
        // super();
    }

    // Two types of constructors
    // 1. default constructor: What Java provides inside of a class IF no user defined constructor is written
    //      - no-args constructor (no parameters defined)
    // 2. user defined constructor(s)
    //      - no-args constructor (no parameters defined)
    //      - parameterized constructor (you do have parameters)

    // Constructor #2
    // It allows you to construct an object with data already provided, so you don't need to do it later
    public Person(String firstName, String lastName, int age) {
        // super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public void speak() {
        System.out.println("Hi, my name is " + firstName + " " + lastName + ". My age is " + age);
    }

}
