package com.revature.main;

import com.revature.model.Person;

public class Driver {

    public static void main(String[] args) {
        Person p1 = new Person("John", "Doe", 18);

        System.out.println(p1.getFirstName());
        System.out.println(p1.getLastName());
        System.out.println(p1.getAge());

        p1.setFirstName("Bach343");
        p1.setLastName("Tran");

        System.out.println(p1.getFirstName());
        System.out.println(p1.getLastName());
        System.out.println(p1.getAge());
    }

}
