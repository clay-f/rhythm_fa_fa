package com.f.bigtalk.decorator;

public class ConcreteDecoratorA extends Decorator {
    private String addedState;

    public void operator() {
        super.operator();
        addedState = "new State";
        System.out.println("具体装饰对象 A 的操作");
    }
}
