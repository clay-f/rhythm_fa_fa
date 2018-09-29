package com.f.resolved;

public class DoubleNodeTask {
    public static void main(String[] args) {
        DoubleNodeStack<String> doubleNodeStack = new DoubleNodeStack<>();
        doubleNodeStack.addLast("a");
        doubleNodeStack.addLast("b");
        doubleNodeStack.show();
    }
}
