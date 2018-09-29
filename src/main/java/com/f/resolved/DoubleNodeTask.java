package com.f.resolved;

public class DoubleNodeTask {
    public static void main(String[] args) {
        DoubleNodeStack<String> doubleNodeStack = new DoubleNodeStack<>();
        doubleNodeStack.addLast("a");
        doubleNodeStack.removeFirst();
        doubleNodeStack.addFirst("a");
        doubleNodeStack.removeLast();
        doubleNodeStack.show();
    }
}
