package com.revature.main;

import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
//        try {
//            a(-10);
//
//            System.out.println("a executed successfully");
//        } catch (NegativeNumberException e) {
//            System.out.println(e.getMessage());
//        }
//
//        System.out.println("End of program");

        // Create a program that does integer division
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Welcome to the division calculator");

                System.out.println("Type 'exit' to exit the calculator or press enter to continue");
                String input = sc.nextLine();
                if (input.equals("exit")) break;

                System.out.println("Enter a numerator (integer): ");

                int numerator = Integer.parseInt(sc.nextLine());

                System.out.println("Enter a denominator (integer): ");
                int denominator = Integer.parseInt(sc.nextLine());

                int result = divide(numerator, denominator);
                System.out.println("The result of " + numerator + "/" + denominator + " is " + result);

            } catch (ZeroNumberException e) {
                System.out.println("Invalid denominator entered. Please enter a non-zero integer");
            } catch (NumberFormatException e) {
                System.out.println("You need to enter a valid integer.");
            }
        }
    }

    public static int divide(int numerator, int denominator) throws ZeroNumberException {
        if (denominator == 0) {
            throw new ZeroNumberException("Denominator cannot be zero");
        }

        return numerator / denominator;
    }

    public static void a(int num) {
        if (num < 0) {
            throw new NegativeNumberException("Cannot have negative numbers");
        }

        System.out.println("We have a number greater than or equal to 0. It is " + num);
    }

}
