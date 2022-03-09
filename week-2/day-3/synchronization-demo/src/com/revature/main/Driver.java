package com.revature.main;

public class Driver {

    public static void main(String[] args) throws InterruptedException {

        Counter c = new Counter();

        Runnable increment = () -> {
            for (int i = 0; i < 1000; i++) {
                c.increment();
            }
        };

        Runnable decrement = () -> {
            for (int i = 0; i < 1000; i++) {
                c.decrement();
            }
        };

        Thread[] incrementThreads = new Thread[100];
        Thread[] decrementThreads = new Thread[100];

        for (int i = 0; i < incrementThreads.length; i++) {
            incrementThreads[i] = new Thread(increment);
            decrementThreads[i] = new Thread(decrement);
        }

        for (int i = 0; i < incrementThreads.length; i++) {
            incrementThreads[i].start();
            decrementThreads[i].start();
        }

        // join: wait for the threads to finish before moving on
        for (int i = 0; i < incrementThreads.length; i++) {
            incrementThreads[i].join();
            decrementThreads[i].join();
        }

        System.out.println(c.value); // 0
    }

}
