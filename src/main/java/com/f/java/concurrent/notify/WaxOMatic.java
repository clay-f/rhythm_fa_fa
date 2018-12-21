package com.f.java.concurrent.notify;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WaxOMatic {
    public static void main(String[] args) throws InterruptedException {
        Car car = new Car();
        var exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff(car));
        exec.execute(new WaxOn(car));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdown();
    }
}
