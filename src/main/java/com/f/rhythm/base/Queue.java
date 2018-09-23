package com.f.rhythm.base;

import java.util.Iterator;
import java.util.Objects;

public class Queue<T> implements Iterable<T> {
    private Node first;
    private Node last;
    private int n = 0;

    public Queue() {
    }

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    public void enqueue(T t) {
        Objects.requireNonNull(t);
        if (first == null) {
            last = new Node(t);
            first = last;
        } else {
            Node oldlast = last;
            last = new Node(t);
            oldlast.next = last;
        }
        n++;
    }

    public T dequeue() {
        Node item = first;
        first = first.next;
        n--;
        return item.item;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    private class Node {
        public Node(T item) {
            this.item = item;
            next = null;
        }
        T item;
        Node next;
    }

    private class QueueIterator implements Iterator<T> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            Node node = current;
            current = current.next;
            return node.item;
        }
    }
}
