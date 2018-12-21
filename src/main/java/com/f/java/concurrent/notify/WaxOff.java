package com.f.java.concurrent.notify;

public class WaxOff implements Runnable {
    private Car car;

    public WaxOff() {
    }

    public WaxOff(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                car.waitForWaxing();
                System.out.println("Wax off!");
                car.buffed();
            }
        } catch (Exception e) {
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending Wax off task");
    }
}
