package com.revature.model;

public class Person {
    // Note: fields have default values

    // static field
    public static int numberOfInstances; // default value of 0

    // instance fields
    public String firstName;
    public String lastName;
    public int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;

        numberOfInstances++; // increment the static field by 1
    }

    // Bonus knowledge
    @Override
    protected void finalize() { // the garbage collector will invoke this method whenever the object gets garbage collected
        numberOfInstances--;
    }

    // instance method
    public void greet() { // instance methods have direct access to instance fields of that particular instance
        System.out.println("Hi! My name is " + this.firstName + " " + this.lastName);
    }

    // static method
    public static void printNumberOfInstances() {
        System.out.println("The number of instances of Person created is " + numberOfInstances);
    }
}
