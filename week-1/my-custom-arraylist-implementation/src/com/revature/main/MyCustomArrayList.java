package com.revature.main;

public class MyCustomArrayList<E> { // <E> is an example of a generic, which allows us to use multiple different types
    // for our MyCustomArrayList

    private int numOfElements; // default value for primitive fields is 0, false, or null
    private E[] value;

    public MyCustomArrayList() {
        this.value = (E[]) new Object[2];
    }

    public MyCustomArrayList(int capacity) {
        this.value = (E[]) new Object[capacity];
    }

    public void add(E element) {
        // Check if num of elements is the same as the size of the array
        if (this.numOfElements == value.length) { // if it is true, then we need to create a new array that is larger
            E[] oldArray = this.value;

            this.value = (E[]) new Object[this.numOfElements * 2]; // Create an array that is double the size of the original

            // Copy over all of the elements from the original array
            for (int i = 0; i < oldArray.length; i++) {
                this.value[i] = oldArray[i];
            }
        }

        this.value[this.numOfElements] = element;
        this.numOfElements++;
    }

    public E get(int index) {
        return this.value[index];
    }

    public int size() {
        return this.numOfElements;
    }

    public boolean isEmpty() {
        return this.numOfElements == 0;
    }

}
