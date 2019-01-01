package com.f.design.proxy;


interface Subject {
    void doSomeThing();
}

class RealSubject implements Subject {
    @Override
    public void doSomeThing() {
        System.out.println("RealSubject doSomething");
    }
}

public class StaticProxy implements Subject {

    private RealSubject subject;

    public StaticProxy() {
        subject = new RealSubject();
    }

    @Override
    public void doSomeThing() {
        subject.doSomeThing();
    }

    public static void main(String[] args) {
        StaticProxy proxy = new StaticProxy();
        proxy.doSomeThing();
    }
}
