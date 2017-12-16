package com.f.bigtalk.decorator;

public class Pants extends  PersonDecorator{
    public void show() {
        super.show();
        System.out.println("👖");
    }
}
