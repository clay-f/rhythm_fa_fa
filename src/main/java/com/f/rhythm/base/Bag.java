package com.f.rhythm.base;

import java.util.Iterator;
import java.util.Objects;

public class Bag<T> implements Iterable<T> {
    private Node first;
    private int n;

    public void add(T t) {
        Objects.requireNonNull(t);
        Node oldfirst = first;
        first = new Node(t);
        first.next = oldfirst;
        n++;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new BagIterator();
    }


    private class Node {
        T item;
        Node next;

        public Node(T item) {
            this.item = item;
            next = null;
        }
    }

    private class BagIterator implements Iterator<T> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }
    }
}
