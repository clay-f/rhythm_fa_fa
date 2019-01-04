package com.f.design.decorator;

public class TestDecorator {
    public static void main(String[] args) {
       var one = new ComponentA();
       var two = new ComponentB();
       var three = new ComponentC();
       one.setComponent(two);
       two.setComponent(three);
       one.operator();
    }
}
