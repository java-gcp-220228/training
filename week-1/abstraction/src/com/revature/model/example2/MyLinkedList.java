package com.revature.model.example2;

public class MyLinkedList<E> implements MyList<E> {

    private int numOfElements;
    private Node head;
    private Node tail;

    class Node<E> {
        private E value;
        private Node next;
    }

    @Override
    public void add(E element) {
        Node<E> newNode = new Node();
        newNode.value = element;

        if (head == null && tail == null) { // LinkedList is empty
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }

        numOfElements++;
    }

    @Override
    public int size() {
        return numOfElements;
    }

    @Override
    public E get(int index) {
        Node<E> currentNode = this.head;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        return currentNode.value;
    }

    @Override
    public boolean isEmpty() {
        return numOfElements == 0;
    }
}
