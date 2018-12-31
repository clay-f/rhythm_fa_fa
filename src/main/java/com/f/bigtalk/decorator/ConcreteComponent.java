package com.f.bigtalk.decorator;

public class ConcreteComponent implements Component {


    @Override
    public void operator() {
        System.out.println("ConcreteComponent method invoked");
    }
}
