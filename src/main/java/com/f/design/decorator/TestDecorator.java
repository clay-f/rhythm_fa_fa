package com.f.design.decorator;

public class TestDecorator {
    public static void main(String[] args) {
        new ComponentA(new ComponentB(new ComponentC())).operator();

        System.out.println("----------------");
        var a = new ComponentA();
        var b = new ComponentB();
        a.setComponent(b);
        a.operator();
    }
}
