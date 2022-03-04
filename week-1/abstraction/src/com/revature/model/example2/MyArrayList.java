package com.revature.model.example2;

import java.util.Iterator;

public class MyArrayList<E> implements MyList<E>, Iterable<E> {

    private int numOfElements;
    private E[] value;

    public MyArrayList() {
        this.value = (E[]) new Object[2];
    }

    public MyArrayList(int initialCapacity) {
        this.value = (E[]) new Object[initialCapacity];
    }

    @Override
    public void add(E element) {
        if (this.numOfElements == this.value.length) { // array is full
            E[] oldArray = this.value;

            this.value = (E[]) new Object[this.numOfElements * 2];

            // Copy over all of the elements
            for (int i = 0; i < oldArray.length; i++) {
                this.value[i] = oldArray[i];
            }
        }

        this.value[numOfElements] = element;
        numOfElements++;
    }

    @Override
    public int size() {
        return this.numOfElements;
    }

    @Override
    public E get(int index) {
        return this.value[index];
    }

    @Override
    public boolean isEmpty() {
        return this.numOfElements == 0;
    }

    @Override
    public Iterator<E> iterator() { // abstract method from the Iterable interface that needs to be implemented
        return new Iterator<E>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < numOfElements;
            }

            @Override
            public E next() {
                E returnValue = value[index];
                index++;

                return returnValue;
            }
        };
    }
}
