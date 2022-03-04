package com.revature.main;

import java.util.Scanner;

public class ShapeFactory {

    public ShapeFactory() {
    }

    public Shape createShape(String type) {

        switch(type) {
            case "triangle":
                System.out.println("Enter a base for the triangle: ");
                double base = Double.parseDouble(Driver.sc.nextLine());
                System.out.println("Enter a height for the triangle: ");
                double height = Double.parseDouble(Driver.sc.nextLine());

                return new Triangle(base, height);
            case "circle":
                System.out.println("Enter a radius for the circle: ");
                double radius = Double.parseDouble(Driver.sc.nextLine());

                return new Circle(radius);
            case "square":
                System.out.println("Enter a side for the square: ");
                double side = Double.parseDouble(Driver.sc.nextLine());

                return new Square(side);
            case "rectangle":
                System.out.println("Enter a length for the rectangle: ");
                double length = Double.parseDouble(Driver.sc.nextLine());
                System.out.println("Enter a width for the rectangle: ");
                double width = Double.parseDouble(Driver.sc.nextLine());

                return new Rectangle(length, width);
        }

        return null;
    }

}
