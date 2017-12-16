package com.f.bigtalk.decorator;

public class Clothes extends PersonDecorator {
    public void show() {
        super.show();
        System.out.println("👔");
    }
}
