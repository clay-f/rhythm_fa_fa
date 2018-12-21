package com.f.java.concurrent.notify;

import java.util.concurrent.TimeUnit;

public class WaxOn implements Runnable {
    private Car car;

    public WaxOn() {
    }

    public WaxOn(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                System.out.println("wax on!");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitForBuffing();
            } catch (InterruptedException e) {
                System.out.println("Exiting via interrupt");
            }
            System.out.println("Ending Wax On task");
        }
    }
}
