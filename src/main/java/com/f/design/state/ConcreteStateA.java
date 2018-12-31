package com.f.design.state;

public class ConcreteStateA implements State {
    @Override
    public void Handle(Context context) {
        System.out.println("hello world");
    }
}
