package com.f.bigtalk.decorator;

public class TestDecorator {
    public static void main(String[] args) {
        ConcreteComponent concreteComponent = new ConcreteComponent();
        ConcreteDecoratorA a = new ConcreteDecoratorA();
        ConcreteDecoratorB b = new ConcreteDecoratorB();
        a.setComponent(concreteComponent);
        b.setComponent(a);
        b.operator();
    }
}
