package com.f.design.simple_factory;

public abstract class Operate {
    private double numberA;
    private double numberB;

    public Operate() {}

    public Operate(double a, double b) {
        this.numberA = a;
        this.numberB = b;
    }

    public double getNumberA() {
        return numberA;
    }

    public void setNumberA(double numberA) {
        this.numberA = numberA;
    }

    public double getNumberB() {
        return numberB;
    }

    public void setNumberB(double numberB) {
        this.numberB = numberB;
    }

    public abstract double getResult();
}
