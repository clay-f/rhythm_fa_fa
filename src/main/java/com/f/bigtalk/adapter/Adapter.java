package com.f.bigtalk.adapter;

public class Adapter extends Target {
    private Adaptee adaptee = new Adaptee();

    public void request() {
        adaptee.SpecificRequest();
    }
}
