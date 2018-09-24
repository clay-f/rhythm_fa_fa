package com.f.rhythm.base;

import java.util.Iterator;
import java.util.Objects;

public class Stack<T> implements Iterable<T> {
    private Node first;
    private int n = 0;

    public Stack() {
    }

    public static Stack copy(Stack stack) {
        Stack copyStack = new Stack();
        for (Iterator iterator = stack.iterator(); iterator.hasNext(); ) {
            copyStack.push(iterator.next());
        }
        return copyStack;
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void push(T t) {
        Objects.requireNonNull(t);
        Node oldfirst = first;
        first = new Node(t);
        first.next = oldfirst;
        n++;
    }

    public T peek() {
        Objects.requireNonNull(first);
        return first.item;
    }

    public T pop() {
        Objects.requireNonNull(first);
        T item = first.item;
        first = first.next;
        n--;
        return item;
    }

    private class Node {
        public Node(T item) {
            this.item = item;
            next = null;
        }

        T item;
        Node next;
    }

    private class StackIterator implements Iterator<T> {
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
