package com.f.java.concurrent.thread.lock;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SynchronizedEventGenerator extends IntGenerator {
    private int currentEventValue = 0;

    @Override
    public synchronized int next() {
        ++currentEventValue;
        System.out.println("first + 1 " +currentEventValue);
        Thread.yield();
        ++currentEventValue;
        System.out.println("second + 1 "  + currentEventValue);
        return currentEventValue;
    }

    public static void main(String[] args) throws InterruptedException {
        var exec = Executors.newFixedThreadPool(3);
        var ge = new SynchronizedEventGenerator();
        for (int i = 0; i < 2; i++) {
            System.out.println("i --> " + i);
            exec.execute(() -> ge.next());
        }

        exec.shutdown();

        TimeUnit.SECONDS.sleep(5);
    }
}
