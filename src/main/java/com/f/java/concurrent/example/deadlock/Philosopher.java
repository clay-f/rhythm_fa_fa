package com.f.java.concurrent.example.deadlock;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Philosopher implements Runnable {
    private Chopstick left;
    private Chopstick right;
    private final int id;
    private final int ponderFactor;
    private Random r = new Random(47);

    public Philosopher(Chopstick left, Chopstick right, int id, int ponderFactor) {
        this.left = left;
        this.right = right;
        this.id = id;
        this.ponderFactor = ponderFactor;
    }

    private void pause() throws InterruptedException {
        if (ponderFactor == 0) {
            return;
        }
        TimeUnit.MILLISECONDS.sleep(ponderFactor * 250);
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println(this + " " + " thinking");
                pause();
                System.out.println(this + " " + "grabing right");
                right.take();
                System.out.println(this + " " + "grabing left");
                left.take();
                pause();
                right.drop();
                left.drop();
            }
        } catch (InterruptedException e) {
            System.err.println(this + " exiting vai interrupt");
        }
    }

    public String toString() {
        return " philosopher " + id;
    }
}
