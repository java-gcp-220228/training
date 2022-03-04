package com.revature.main;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Driver {

    public static void main(String[] args) {
        // Class A implements MyFunctionalInterface (traditional)
        MyFunctionalInterface mfi1 = new A();
        mfi1.myMethod();

        // Anonymous classes
        MyFunctionalInterface mfi2 = new MyFunctionalInterface() { // We are defining a class without a name
            // to implement the interface
            @Override
            public void myMethod() {
                System.out.println("Anonymous class example");
            }
        }; // Implementing the interface and instantiating the object

        mfi2.myMethod();

        // Lambda expressions
        // Think of lambda expressions as being a "syntax shortcut" for an anonymous class
        // The one difference between an anonymous class and a lambda is that you can implement
        // multiple methods in an anonymous class, but the lambda expression is only a single
        // method
        // Lambda expressions only work with functional interfaces, since functional interfaces
        // by definition only have a single abstract method
        MyFunctionalInterface mfi3 = () -> {
            System.out.println("Lambda expression example");
        }; // implementing the interface and instantiating the object

        mfi3.myMethod();


        /*
            MyPredicate (our own class)
         */

        MyPredicate<String> checkIfStringLengthGreaterThan10 = (String s) -> {
            return s.length() > 10;
        };

        String s = "Hello there my name is Bach";

        System.out.println(checkIfStringLengthGreaterThan10.test(s));

        // Java comes with a lot of functional interfaces that exist
        // in the java.util.function package

        // Example of Java's built-in Predicate
        Predicate<String> checkIfStringHasNoCharacters = (String str) -> {
            return str.length() == 0;
        };

        // Consumer
        Consumer<Integer> printOutAs = (Integer j) -> {
            for (int i = 0; i < j; i++) {
                System.out.print("A");
            }

            System.out.println();
        };

        printOutAs.accept(10);

        // BiConsumer
        BiConsumer<Integer, Integer> addNumbers = (Integer i1, Integer i2) -> {
            System.out.println(i1 + i2);
        };

        addNumbers.accept(10, 20);

        BiFunction<Integer, Integer, Integer> returnSum = (i1, i2) -> {
            return i1 + i2;
        };

        System.out.println(returnSum.apply(4, 5));

        Comparator<String> test = (s1, s2) -> {
            return s1.compareTo(s2);
        };
    }

}
