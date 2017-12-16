package com.f.bigtalk.proxy;

public class RealSubject implements Subject {
    @Override
    public void doSometing() {
        System.out.println("RealSubject doSomething");
    }
}
