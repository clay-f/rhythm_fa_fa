package com.f.bigtalk.proxy;

public class RealSubject implements Subject {
    @Override
    public void doSomeThing() {
        System.out.println("RealSubject doSomething");
    }
}
