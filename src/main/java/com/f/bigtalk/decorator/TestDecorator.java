package com.f.bigtalk.decorator;

public class TestDecorator {
    public static void main(String[] args) {
        ConcreteComponentA foo = new ConcreteComponentA();
        ConcreteComponentB bar = new ConcreteComponentB();
        foo.setComponent(bar);
        foo.operation();
    }
}
