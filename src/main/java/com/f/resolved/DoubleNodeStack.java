package com.f.resolved;

import java.util.Objects;

public class DoubleNodeStack<T> {
    private DoubleNode first;
    private DoubleNode last;

    private class DoubleNode {
        private DoubleNode prev;
        private T item;
        private DoubleNode next;

        public DoubleNode(T item) {
            prev = null;
            this.item = item;
            next = null;
        }
    }

    public void addFirst(T t) {
        DoubleNode oldfirst = first;
        first = new DoubleNode(t);
        if (oldfirst == null) {
            last = first;
        } else {
            first.next = oldfirst;
            oldfirst.prev = first;
        }

    }

    public void addLast(T t) {
        DoubleNode oldLast = last;
        last = new DoubleNode(t);
        oldLast.next = last;
        last.prev = oldLast;
    }

    public T removeFirst() {
        DoubleNode oldfirst = first;
        first = oldfirst.next;
        oldfirst.next = null;
        first.prev = null;
        return oldfirst.item;
    }

    public T removeLast() {
        DoubleNode item = last;
        last = last.prev;
        last.next = null;
        item.prev = null;
        return item.item;
    }

    public void addBefore(T target, T newVal) {
        addBefore(first, target, newVal);
    }

    private void addBefore(DoubleNode node, T target, T newVal) {
        if (node == null) return;
        if (node.item.equals(target)) {
            DoubleNode newNode = new DoubleNode(newVal);
            if (node.prev == null) {
                node.prev = newNode;
                newNode.next = node;
            } else {
                DoubleNode oldnode = node.prev;
                oldnode.next = newNode;
                newNode.prev = oldnode;
                newNode.next = node;
                node.prev = newNode;
            }
        } else {
            addBefore(node.next, target, newVal);
        }
    }

    public void addAfter(T target, T newVal) {
        Objects.requireNonNull(target);
        Objects.requireNonNull(newVal);
        addAfter(first, target, newVal);
    }

    private void addAfter(DoubleNode node, T target, T newVal) {
        if (node == null) return;
        if (node.item.equals(target)) {
            DoubleNode newNode = new DoubleNode(newVal);
            if (node.next == null) {
                node.next = newNode;
                newNode.prev = node;
            } else {
                DoubleNode oldnext = node.next;
                node.next = newNode;
                newNode.prev = node;
                newNode.next = oldnext;
                oldnext.prev = newNode;
            }
        } else {
            addAfter(node.next, target, newVal);
        }
    }

    public void show() {
        show(first);
    }

    private void show(DoubleNode doubleNode) {
        for (DoubleNode item = doubleNode; item != null; item = item.next) {
            System.out.print(item.item + " ");
        }
    }
}
