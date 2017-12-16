package com.f.studyDesignPatterns.interfacePattern.interfaceAdapter;

public class PhysicalRocket {
    double burnArea;
    double burnRate;
    double fuelMass;
    double totalMass;

    public PhysicalRocket() {}

    public PhysicalRocket(double burnArea, double burnRate, double fuelMass, double totalMass) {
        this.burnArea = burnArea;
        this.burnRate = burnArea;
        this.fuelMass = fuelMass;
        this.totalMass = totalMass;
    }

   double getBurnTime() {
        return 0;
   }

   double getMass(double t) {
        return 0;
   }

   double getThrust(double t) {
        return 0;
   }
}
