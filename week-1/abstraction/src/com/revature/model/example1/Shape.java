package com.revature.model.example1;

public abstract class Shape {

    protected String name;

    // We have defined a constructor in the abstract class
    // BUT, we cannot instantiate abstract classes
    public Shape(String name) {
        this.name = name;
    }

    // Abstract method
    public abstract double calculateArea();

    public String getName() {
        return name;
    }

}
