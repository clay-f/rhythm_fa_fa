package com.f.studyDesignPatterns.interfacePattern.interfaceAdapter;

public class Skyrocket {
    protected double simTime;

    double masss;
    double thrust;
    double burnTime;

    public  Skyrocket(double thrust, double masss, double burnTime) {
        this.masss = masss;
        this.thrust = thrust;
        this.burnTime = burnTime;
    }

    public Skyrocket() {}

    double getMasss() {
        return masss;
    }

    double getThrust() {
        return thrust;
    }

    public void setSimTime(double simTime) {
        this.simTime = simTime;
    }
}
