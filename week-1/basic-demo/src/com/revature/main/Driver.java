package com.revature.main; // package names follow a "reverse domain" naming convention
// So if you work for Revature, then the package names will start with com.revature.<whatever here>
// com.google.<whatever here>

import com.revature.model.Person; // If a class needs to use another class in a different package,
// then it needs to import that class using the "fully qualified class name" (com.revature.model.Person)
// <package name>.<class name>

public class Driver {

    // Main is the entrypoint to the application
    // It is always the first method that gets executed when you run your Java program
    // So, main is a special method that ALWAYS has the signature "public static void main(String[] args) {}"
    public static void main(String[] args) {
        System.out.println("Hello world!");

        methodA();
        methodB("abcdefg");

        // We are constructing a Person object
        Person p1 = new Person(); // The new keyword allocates a space in memory for an object
        // Person() is what is known as a constructor which will construct the object

        // ^^ name of variable is p1 of the type "Person"
        // p1 is "referring" to the actual Person object
        // p1 is not the object itself

        // Populate the object's properties with values
        p1.firstName = "John";
        p1.lastName = "Doe";
        p1.age = 18;

        // Invoking a behavior of that particular object
        p1.speak(); // Hi, my name is John

        /*
            Jane
         */
        Person myPerson = new Person("Jane", "Doe", 25);
        myPerson.speak(); // Hi, my name is Jane

        myPerson = null; // myPerson is no longer pointing to the Jane Doe object

        System.out.println("End of main() method");
    }

    public static void methodA() {
        System.out.println("Running methodA()!!!");
        methodB("xyz");
    }

    // Methods are blocks of code that can be executed by other blocks of code
    // Methods typically take an input and give an output
    // The type of output here is "void", which means there is no output from the method
    // The type of input is a String (sequence of characters)
    public static void methodB(String myString) {
        System.out.println("myString: " + myString);
    }

}
