package com.revature.main;

import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        // Primitives
        // 1. byte
        // 2. short
        // 3. char
        // 4. int
        // 5. long
        // 6. float
        // 7. double
        // 8. boolean

        // Casting: converting from one type of variable to another
        // Primitive casting
        //      1. Widening casting: fitting a smaller type into a larger type
        //          - Implicit
        //          - "safe" conversion: you won't lose any information
        //      2. Narrowing casting: fitting a larger type into a smaller type
        //          - Explicit
        //          - "unsafe" conversion: you COULD lose information

        Scanner sc = new Scanner(System.in); // We are using a Scanner object to "scan" for input by the user
        System.out.println("Enter a number to convert to a byte: ");
        int i = sc.nextInt();
        sc.close();

        byte b = (byte) i; // range of a byte is -128 to 127
        System.out.println("b: " + b);

        // 1000 (decimal) -> 1111101000 (binary)
        // -> convert to byte -> xx11101000 (binary) -> -24
        //                     We lost 2 bits of information here

        /*
            Widening conversion

            Remember this type of conversion is "implicit" (safe)
         */
        double d = 3.14; // 3.14 is a double literal
        float f = 3.14f; // 3.14f is a "float literal"

        long myLong = 1123123123213213332L; // L "long literal"
        float myFloat = myLong; // A long will fit into a float (even though a long is 64 bits and a float is 32 bits)
        // Because a float has a wider range than a long

        /*
            Operators:

            1. Arithmetic Operators
                + ADDITION
                - SUBTRACTION
                * MULTIPLICATION
                / DIVISION
                % MODULUS <- Get the remainder of division 5 % 2 = 1
            2. Assignment Operators
                =
                += (x += 10 equivalent to x = x + 10)
                -= (x -= 10 equivalent to x = x - 10)
                *=  ...
                /=
                %=
                ++ (prefix and postfix)
                -- (prefix and postfix)
            3. Logical Operators
                && AND
                || OR
                ! NOT
            4. Comparison Operators
                != NOT EQUALS
                == EQUALS
                >= GREATER THAN OR EQUALS
                <= LESS THAN OR EQUALS
                > GREATER THAN
                < LESS THAN
            5. Bitwise Operators (not covering)
            6. Ternary Operator
         */

        // Numeric promotion
        // whenever you use a "binary" operator (a number on the left side and a number on the right side)
        // ex. + <- binary operator
        // It will automatically convert any primitives smaller than an int to an int
        byte b1 = 100;
        byte b2 = 10;

        byte b3 = (byte) (b1 + b2); // b1 + b2 -> byte + byte -> int + int -> int

        // Expression v. Statement
        //  Expression <- evaluates to a single value
        //  Statement <- a whole line of code

        // Ternary Operator
        // <boolean condition> ? <expression if true> : <expression if false>
        boolean isSunny = true;

        String todaysActivity = (isSunny ? "Going to the park" : "Staying indoors");
        System.out.println(todaysActivity);

        int x = 10;
        System.out.println(x++); // postfix gives you the original value of 10
        System.out.println(x); // 11

        int y = 10;
        System.out.println(++y); // 11
        System.out.println(y); // 11

        // Logical operators
        // 1. Non short-circuiting operators
        //      &
        //      |
        // 2. Short-circuiting operators (normal)
        //      && AND
        //      || OR

        // AND: both sides must be true
        //  false && ? = false <- short-circuiting situation
        // OR: only one side needs to be true
        //  true || ? = true <- short-circuiting situation
        boolean myBool1 = giveFalse() && giveTrue(); // giveTrue() DOES NOT RUN!!!
        boolean myBool2 = giveTrue() || giveFalse(); // giveFalse() DOES NOT RUN!!!

        // This situation CANNOT short-circuit
        boolean myBool3 = giveTrue() && giveTrue(); // Both sides need to run
    }

    public static boolean giveTrue() {
        System.out.println("giveTrue() invoked"); // breadcrumb statements (often a very useful debugging strategy
        // when you run into problems)
        return true;
    }

    public static boolean giveFalse() {
        System.out.println("giveFalse() invoked");
        return false;
    }

}
