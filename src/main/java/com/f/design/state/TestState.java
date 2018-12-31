package com.f.design.state;

public class TestState {
    public static void main(String[] args) {
        Context context = new Context(new ConcreteStateA());
        context.request();
    }
}
