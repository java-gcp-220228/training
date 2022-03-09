package com.revature.main;

public class Counter {

    public int value; // 0 by default

    // To avoid race-conditions, we need to make this class "thread-safe"
    // This is done by synchronizing blocks of code using the "synchronized" keyword
    private Object lock = new Object(); // Here we are creating an object that will serve
    // as a "key and lock"
    // There's only 1 key per lock
    // So, if a key is already being used by a thread, no other thread can enter the block(s)
    // using that lock
    // Threads will give back the key when they are done with the synchronized block they are executing
    // And then the other threads can fight to see who gets the key next

    public void increment() {
        synchronized(lock) {
            value++; // It's just 1 line of code, but in reality there are many different operations
            // 1. read the original value of value
            // 2. add the original value and 1
            // 3. assign the original value + 1 to value
        }
    }

    // If you have the synchronized keyword directly on a method, it will utilize the
    // instance itself as the lock
    public /* synchronized*/ void decrement() {
        synchronized(lock) {
            value--;
        }
    }

}
