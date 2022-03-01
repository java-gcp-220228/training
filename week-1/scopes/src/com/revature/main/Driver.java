package com.revature.main;

import com.revature.model.Person;

public class Driver {

    public static void main(String[] args) {
        int x = 100; // method scoped variable
        // You can access it inside of ANY block within this method

        System.out.println(x);

        if (true) {
            System.out.println(x);

            int y = 1000; // block scoped variable
            System.out.println(y);
        }

        for (int i = 0; i < 100; i++) { // i is block scoped
        }

        for (int i = 0; i < 50; i++) {
        }

        /*
            Static v. Nonstatic
         */
        System.out.println(Person.numberOfInstances); // static variables can be accessed from the class itself
        Person.printNumberOfInstances(); // invoking a static method that exists inside of the Person class

        Person p1 = new Person("John", "Doe", 18);
        p1.greet();
        System.out.println(p1.firstName);
        System.out.println(p1.lastName);
        System.out.println(p1.age);

        Person p2 = new Person("Jane", "Doe", 25);
        p2.greet();
        System.out.println(p2.firstName);
        System.out.println(p2.lastName);
        System.out.println(p2.age);

        Person.printNumberOfInstances();

        p1 = null;
        p2 = null;

        // Suggest the garbage collector to run
        System.gc();
        for (int i = 0; i < 100000; i++) {} // delay the program so that the garbage collector has enough time
        // to garbage collect the Person objects

        Person.printNumberOfInstances();
    }

}
