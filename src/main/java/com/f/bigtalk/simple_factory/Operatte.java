package com.f.bigtalk.simple_factory;

public class Operatte extends Operate {
    public Operatte() {}

    public Operatte(double a, double b) {
        super(a, b);
    }

    @Override
    public double getResult() {
        return getNumberA() - getNumberB();
    }
}
