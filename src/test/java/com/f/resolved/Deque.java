package com.f.resolved;

import java.util.Objects;

public class Deque<T> {
    private Node first;
    private Node last;
    private Integer n;

    public Deque() {
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void pushLeft(T t) {
        Node oldfirst = first;
        first = new Node(t);
        first.next = oldfirst;
        if (oldfirst == null) {
            last = first;
        } else {
            oldfirst.prev = first;
        }
        n++;
    }

    public void pushRight(T t) {
        Node oldlast = last;
        last = new Node(t);
        last.prev = oldlast;
        if (oldlast == null) {
            first = last;
        } else {
            oldlast.next = last;
        }
        n++;
    }

    public T popLeft() {
        Objects.requireNonNull(first);
        Node item = first;
        if (first.next == null) {
            first = null;
        } else {
            first.next.prev = null;
            first = first.next;
        }
        n--;
        return item.item;

    }

    public T popRight() {
        Objects.requireNonNull(last);
        Node item = last;
        if (last.prev == null) {
            last = null;
        } else {
            last.prev.next = null;
            last = last.prev;
        }
        n--;
        return last.item;
    }

    private class Node {
        Node prev;
        T item;
        Node next;

        public Node(T item) {
            this.item = item;
        }
    }

    public static void main(String[] args) {
        Deque<String> deque = new Deque<>();
        deque.pushRight("a");
        deque.pushLeft("b");
        deque.pushRight("c");
        deque.popRight();
        System.out.println("");
    }
}
