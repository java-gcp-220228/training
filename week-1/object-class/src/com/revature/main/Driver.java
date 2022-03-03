package com.revature.main;

import com.revature.model.Person;

public class Driver {

    public static void main(String[] args) {
        Person p = new Person("John", "Doe", 18);
        Person p2 = new Person("John", "Doe", 18);

        String s = p.toString();
        System.out.println(s);

        System.out.println(p);

        System.out.println("p == p2: " + (p == p2)); // false
        System.out.println("p.equals(p2): " + (p.equals(p2))); // true, after overriding the equals method

        System.out.println("p.hashCode(): " + (p.hashCode()));
    }

}
