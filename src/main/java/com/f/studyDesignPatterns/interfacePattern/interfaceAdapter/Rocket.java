package com.f.studyDesignPatterns.interfacePattern.interfaceAdapter;

public class Rocket {
    String name;

    double price;

    double pogee;

    public Rocket() {}

    public Rocket(String name, double price, double pogee) {
        this.name = name;
        this.price = price;
        this.pogee = pogee;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getPogee() {
        return pogee;
    }
}
