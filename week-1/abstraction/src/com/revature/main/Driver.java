package com.revature.main;

import com.revature.model.example1.Circle;
import com.revature.model.example1.Rectangle;
import com.revature.model.example1.Shape;
import com.revature.model.example1.Triangle;
import com.revature.model.example2.MyArrayList;
import com.revature.model.example2.MyLinkedList;
import com.revature.model.example2.MyList;

public class Driver {

    public static void main(String[] args) {
        Shape s = new Triangle(10, 5);
        System.out.println(s.getName());
        System.out.println("Area of s: " + s.calculateArea()); // Runtime polymorphism

        s = new Circle(5.5);
        System.out.println(s.getName());
        System.out.println(s.calculateArea()); // Runtime polymorphism

        s = new Rectangle(10, 12);
        System.out.println(s.getName());
        System.out.println(s.calculateArea()); // Runtime polymorphism

        MyList<String> myStrings = new MyArrayList<>();
        myStrings.add("String 1");
        myStrings.add("String 2");
        myStrings.add("String 3");
        myStrings.add("String 4");
        myStrings.add("String 5");

        for (int i = 0; i < myStrings.size(); i++) {
            System.out.println(myStrings.get(i));
        }

        MyList<String> myStrings2 = new MyLinkedList<>();
        myStrings2.add("a");
        myStrings2.add("b");
        myStrings2.add("c");
        myStrings2.add("d");
        myStrings2.add("e");

        for (int i = 0; i < myStrings2.size(); i++) {
            System.out.println(myStrings2.get(i));
        }

        System.out.println("myStrings.get(2): " + myStrings.get(2)); // O(1) ArrayList
        System.out.println("myStrings2.get(2): " + myStrings2.get(2)); // O(n) LinkedList

        MyArrayList<Integer> myInts = new MyArrayList<>();
        myInts.add(10);
        myInts.add(12);
        myInts.add(15);

        for (int i : myInts) {
            System.out.println(i);
        }
    }

}
