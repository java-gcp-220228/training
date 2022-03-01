package com.revature.main;

import com.revature.model.A;

public class Driver {

    public static void main(String[] args) {
        A a1 = new A(5, 10, 15, 20);
        a1.printProperties();

        System.out.println(a1.z); // we only have direct access to the public instance field, z

        B b1 = new B(-1, -2, 3, 10);
        System.out.println(b1.z);
        b1.getY();
    }

}
