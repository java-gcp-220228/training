package com.revature.main;

import java.util.ArrayList;

public class Driver {

    public static void main(String[] args) {
        Person p1 = new Person("John", "Doe", 18);
        Person p2 = new Person("Jane", "Doe", 24);
        Person p3 = new Person("Bach", "Tran", 24);

//        ArrayList<Person> people = new ArrayList<>();
//        people.add(p1);
//        people.add(p2);
//        people.add(p3);

//        System.out.println(people);

        MyCustomArrayList<Person> people = new MyCustomArrayList<>();
        people.add(p1);
        people.add(p2);
        people.add(p3);

        for (int i = 0; i < people.size(); i++) {
            System.out.println(people.get(i));
        }



        MyCustomArrayList<String> myStrings = new MyCustomArrayList<>();
        myStrings.add("String 1");
        myStrings.add("String 2");
        myStrings.add("String 3");
        myStrings.add("String 4");
        myStrings.add("String 5");

        for (int i = 0; i < myStrings.size(); i++) {
            System.out.println(myStrings.get(i));
        }


        /*
            Wrapper class: a class that serves as a blueprint for creating objects that wrap corresponding
            primitive values inside of them

            1. Byte class
            2. Short class
            3. Character class
            4. Integer class
            5. Long class
            6. Float class
            7. Double class
            8. Boolean class

            One primary reason for wrapper classes is so that you can utilize primitives with Generics
            Generics form a strong foundation for general Collection types that can be constructed for
            many different types of objects

         */

        Integer wrapper1 = new Integer(10);

        // AUTOBOXING: automatic instantiation of a wrapper object based on a primitive value
        Integer wrapper2 = 15; // new Integer(15);

        // UNBOXING: automatic unpacking of a primitive value inside of a wrapper object
        int sum = 10 + wrapper2; // int + reference variable -> int + int = int
        System.out.println(sum);

        MyCustomArrayList<Integer> myInts = new MyCustomArrayList<>();
        myInts.add(wrapper1);
        myInts.add(wrapper2);
        myInts.add(100); // AUTOBOXING: int -> Integer

        for (int i = 0; i < myInts.size(); i++) {
            System.out.println(myInts.get(i));
        }
    }

}
