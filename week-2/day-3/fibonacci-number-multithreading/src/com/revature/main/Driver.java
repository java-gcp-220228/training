package com.revature.main;

import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        // 1    1   2   3   5   8   13   21 ...
        // 0th 1st 2nd

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Enter the nth fibonacci number that you would like to calculate (or type exit to quit): ");
            String choice = sc.nextLine();

            if (choice.equals("exit")) break;

            try {
                int n = Integer.parseInt(choice);

                Runnable r = () -> {
                    NumberUtility nu = new NumberUtility();
                    long result = nu.calculateNthFibMemoize(n);
                    System.out.println("The " + n + "th fib is " + result);
                };
                Thread t = new Thread(r);
                t.start();

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please provide an integer value for n");
                continue;
            }

        }
    }

}
