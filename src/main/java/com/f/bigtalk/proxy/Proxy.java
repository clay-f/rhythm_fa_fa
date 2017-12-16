package com.f.bigtalk.proxy;

public class Proxy implements Subject {

    private RealSubject subject;

    public Proxy() {
        subject = new RealSubject();
    }

    @Override
    public void doSometing() {
        subject.doSometing();
    }
}
