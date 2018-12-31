package com.f.design.prototype;

public class TestPrototype {
    public static void main(String[] args) {
        try {
            ConcretePrototype1 prototype1 = new ConcretePrototype1("foo");
            ConcretePrototype1 prototype2 = (ConcretePrototype1) prototype1.cloneSecond();

            System.out.println(prototype1.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
