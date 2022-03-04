package com.revature.datastructure;

import java.util.NoSuchElementException;

// Implement a stack without using any pre-existing collections
// You can't use the LinkedList class or anything else like that
public class MyStack<E> {

    // push(E element)
    // E pop()

    private int numOfElements;
    private E[] value;

    public MyStack() {
        this.value = (E[]) new Object[2];
    }

    public void push(E element) {
        if (this.numOfElements == this.value.length) {
            E[] oldArray = this.value;

            this.value = (E[]) new Object[this.numOfElements * 2];

            // Copy elements from old array
            for (int i = 0; i < oldArray.length; i++) {
                this.value[i] = oldArray[i];
            }
        }

        this.value[numOfElements] = element;
        numOfElements++;
    }

    public E pop() {
        if (this.numOfElements == 0) {
            // Unchecked Exception
            throw new NoSuchElementException("Stack is empty");
        }

        E returnValue = this.value[numOfElements - 1];
        this.value[numOfElements - 1] = null;
        numOfElements--;

        return returnValue;
    }

    public int size() {
        return this.numOfElements;
    }

}
