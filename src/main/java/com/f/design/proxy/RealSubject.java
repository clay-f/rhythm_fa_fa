package com.f.design.proxy;

public class RealSubject implements Subject {
    @Override
    public void doSomeThing() {
        System.out.println("RealSubject doSomething");
    }
}
