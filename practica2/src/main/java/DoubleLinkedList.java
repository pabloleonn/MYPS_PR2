<<<<<<< Updated upstream:practica2/src/main/java/DoubleLinkedList.java
=======
package org.mps.deque;

import java.util.LinkedList;

>>>>>>> Stashed changes:practica2/src/main/org/mps/deque/DoubleLinkedList.java
public class DoubleLinkedList<T> implements DoubleLinkedQueue<T> {

    private LinkedNode<T> first;
    private LinkedNode<T> last;
    private int size;

    public DoubleLinkedList() {
        this.first = new LinkedNode<T>(null, null, null);
        this.last = new LinkedNode<T>(null, null, null);
        this.size = 0;
    }

    @Override
    public void prepend(T value) {
        LinkedNode<T> newNode = new LinkedNode<T>(value, null, first);
        LinkedNode<T> oldFirst = first;

        this.first = newNode;
        this.first.setNext(oldFirst);
    }

    @Override
    public void append(T value) {
        LinkedNode<T> newNode = new LinkedNode<T>();
    }

    @Override
    public void deleteFirst() {
        // TODO
    }

    @Override
    public void deleteLast() {
        // TODO
    }

    @Override
    public T first() {
        // TODO
        return null;
    }

    @Override
    public T last() {
        // TODO
        return null;
    }

    @Override
    public int size() {
        // TODO
        return 0;
    }
}
