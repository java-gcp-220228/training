package com.revature.main;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread name: " + Thread.currentThread().getName());
        for (int i = 0; i < 100000; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }

}
