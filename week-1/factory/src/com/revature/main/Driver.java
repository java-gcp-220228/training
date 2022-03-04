package com.revature.main;

import java.util.Scanner;

public class Driver {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Client
        // 1. uses ShapeFactory
        // 2. uses Shape interface

        ShapeFactory sf = new ShapeFactory();

        System.out.println("Choose triangle, circle, square, or rectangle: ");
        String choice = Driver.sc.nextLine();

        Shape s = sf.createShape(choice);
        System.out.println(s.getArea());
    }

}
