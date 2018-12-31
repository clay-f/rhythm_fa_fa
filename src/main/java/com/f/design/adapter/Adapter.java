package com.f.design.adapter;

public class Adapter extends Target {
    private Adaptee adaptee = new Adaptee();

    public void request() {
        adaptee.SpecificRequest();
    }
}
