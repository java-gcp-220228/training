package com.revature.main;

public class MyTask extends Thread {

    // The run method is the entry point for a new thread created from this class
    @Override
    public void run() {
        System.out.println("Thread name: " + Thread.currentThread().getName());
        for (int i = 0; i < 100000; i++) {
            System.out.println(i);
        }
    }

}
