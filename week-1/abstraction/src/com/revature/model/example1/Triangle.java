package com.revature.model.example1;

public class Triangle extends Shape {

    private double base;
    private double height;

    public Triangle(double base, double height) {
        super("Triangle");
        this.base = base;
        this.height = height;
    }

    // Implementing the abstract method from Shape
    @Override
    public double calculateArea() {
        return 0.5 * this.base * this.height; // area of a triangle
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
