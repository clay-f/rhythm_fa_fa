package com.f.java.concurrent.atom;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest implements Runnable {
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private int evenIncrement() {
        return atomicInteger.addAndGet(2);
    }

    public int getAtomicInteger() {
        return atomicInteger.get();
    }

    @Override
    public void run() {
        while (true)
            evenIncrement();
    }

    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.err.println("Aborting");
                System.exit(0);
            }
        }, 5000);


        var exec = Executors.newFixedThreadPool(10);
        AtomicIntegerTest atomicIntegerTest = new AtomicIntegerTest();
        exec.execute(atomicIntegerTest);
        while (true) {
            int val = atomicIntegerTest.getAtomicInteger();
            if (val % 2 != 0){
                System.out.println(val);
                System.exit(0);
            }
        }
    }

}
