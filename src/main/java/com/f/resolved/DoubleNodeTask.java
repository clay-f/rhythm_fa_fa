package com.f.resolved;

public class DoubleNodeTask {
    public static void main(String[] args) {
        DoubleNodeStack<String> doubleNodeStack = new DoubleNodeStack<>();
        doubleNodeStack.addFirst("a");
        doubleNodeStack.addFirst("b");
        doubleNodeStack.addFirst("c");
        doubleNodeStack.addAfter("b", "---bb--");
        doubleNodeStack.show();
    }
}
