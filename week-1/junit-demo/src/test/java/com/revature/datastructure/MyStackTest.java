package com.revature.datastructure;

import org.junit.jupiter.api.*;

import java.util.NoSuchElementException;

public class MyStackTest {

    private MyStack<String> stack;

    /*
        Positive Test: We are testing to see if what actually happens is what is expected
            based on the user using the module correctly

        Negative Test: We are testing to see if what actually happens is what is expected
            based on the user using the module incorrectly
            ex. Popping from an empty stack is something you shouldn't do
                But we want to see what should actually happen if a user does so
                In this case, NoSuchElementException should be thrown

        Test cases should follow the AAA pattern
        1. Arrange: set up required objects for the "system under test" (SUT)
        2. Act: invoke the method that you are testing
        3. Assert: see if the method worked properly using the various assertions available
            in the testing framework (such as Jupiter)
     */

    /*
        Jupiter Annotations
        1. @Test (place onto a method that will serve as a test case)
        2. @BeforeAll (place onto a method that will be run before any test cases run)
        3. @BeforeEach (place onto a method that will be run before each and every
            test case)
        4. @AfterEach (place onto a method that will be run after each and every test case)
        5. @AfterAll (place onto a method that will be run after all tests cases have
            already been executed)
     */

    /*
        Jupiter Assertions

        .assertEquals(expected, actual)
        .assertTrue(boolean)
        .assertFalse(boolean)
        .assertArrayEquals(arr1, arr2)
        .assertThrows(exception, () -> { ... })
        .assertNotEquals
        .assertNotNull
        .assertNull
        .assertSame(..., ...) <- if they point to the same object (same reference)
        .fail()
     */

//    @BeforeAll
//    public static void someMethodBeforeAll() {
//        System.out.println("Runs before all test cases");
//    }

    @BeforeEach
    public void setUp() {
        stack = new MyStack<>();
    }

//    @AfterEach
//    public void tearDown() {
//        System.out.println("Runs after each test case");
//    }
//
//    @AfterAll
//    public static void someMethodAfterAll() {
//        System.out.println("Runs after all test cases have ran");
//    }


    // Positive Test
    @Test
    public void testPushToStack_andCheckSize() {
        // AAA
        // 1. Arrange
        // 2. Act
        // 3. Assert

        /*
            Arrange
         */
//        MyStack<String> stack = new MyStack<>();

        /*
            Act
         */
        stack.push("String 1");
        stack.push("String 2");
        int size = stack.size();

        /*
            Assert
         */
        Assertions.assertEquals(2, size);
    }

    // Positive Test
    @Test
    public void testPushToStack_andPopElements() {
//        MyStack<String> stack = new MyStack<>();

        stack.push("String 1");
        stack.push("String 2");

        String element1 = stack.pop(); // String 2
        String element2 = stack.pop(); // String 1

        Assertions.assertEquals("String 2", element1);
        Assertions.assertEquals("String 1", element2);
    }

    // Negative test
    @Test
    public void testPopFromEmptyStack() {
//        MyStack<String> stack = new MyStack<>();

        // IF the exception occurs, THEN the test passes
        Assertions.assertThrows(NoSuchElementException.class,
                () -> {
                    stack.pop();
                }
        );
    }

}
