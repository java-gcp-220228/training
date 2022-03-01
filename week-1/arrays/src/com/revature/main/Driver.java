package com.revature.main;

public class Driver {

    public static void main(String[] args) {

        // Default values in Java for arrays:
        // numbers (0 or 0.0)
        // boolean (false)
        // reference types (null)

        // 1. Create an array with default values
        int[] myIntArray1 = new int[10]; // This array will always have a size of 10

        for (int i = 0; i < myIntArray1.length; i++) {
            System.out.println(myIntArray1[i]); // 0 (primitives cannot be null, only reference types can)
        }

        myIntArray1[0] = 12;
        myIntArray1[1] = 53;
        myIntArray1[2] = -10;
        myIntArray1[3] = -5;

        // 2. Create an array with pre-populated values
        int[] myIntArray2 = new int[] { 5, 2, -10, 53, -50 }; // This array will always have a size of 5
        for (int i = 0; i < myIntArray2.length; i++) {
            System.out.println(myIntArray2[i]); // 0 (primitives cannot be null, only reference types can)
        }

        // 3. Shorthand for 2nd way
        int[] myIntArray3 = { -5, 2, 10, 5, 1000 };
        for (int i = 0; i < myIntArray3.length; i++) {
            System.out.println(myIntArray3[i]); // 0 (primitives cannot be null, only reference types can)
        }

        /*
            2D Arrays
         */
        int[][] my2DArray = new int[][] { {1, 2, 3}, {4, 5, 6} };
        // "2 arrays inside of another array"

        // 1, 2, 3
        // 4, 5, 6
        for (int i = 0; i < my2DArray.length; i++) { // my2DArray.length is 2
            for (int j = 0; j < my2DArray[i].length; j++) {
                System.out.println(my2DArray[i][j]);
            }
        }

        // For-each loop
        for (int[] arr : my2DArray) {
            for (int element : arr) {
                System.out.println(element);
            }
        }

        /*
            Reference variable
         */
        int[] myArr3 = { 1, 2, 3 }; // array variables are REFERENCE variables, because arrays are objects
        int[] myArr4 = myArr3;

        myArr4[2] = 10000;
        System.out.println(myArr3[2]); // 10000, because myArr3 is pointing to the same array as myArr4

        final int[] myArr5 = myArr4;
        myArr5[1] = 3000; // final doesn't mean you can't change the values of the array, it means you can't have
        // myArr5 point to a different array
        
    }

}
