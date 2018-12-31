package com.f.design.decorator;

public class ConcreteDecoratorB extends Decorator {
    public void operator() {
        super.operator();
        helloWorld();
        System.out.println("具体装饰对象 B 调用");
    }

    public void helloWorld() {
        System.out.println("hello world");
    }
}
