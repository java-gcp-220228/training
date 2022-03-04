package com.revature.main;

import com.revature.datastructure.MyStack;

public class Driver {

    public static void main(String[] args) {
        MyStack<String> myStack = new MyStack<>();

        myStack.push("String 1");
        myStack.push("String 2");

        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }

}
