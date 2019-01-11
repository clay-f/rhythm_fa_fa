package com.f.java.concurrent.collection;

import com.f.java.concurrent.example.LiftOff;

import java.util.concurrent.BlockingQueue;

public class LiftOffRunner implements Runnable {
    private BlockingQueue<LiftOff> rockets;

    public LiftOffRunner(BlockingQueue<LiftOff> rockets) {
        this.rockets = rockets;
    }

    public void add(LiftOff off) {
        try {
            rockets.put(off);
        } catch (InterruptedException e) {
            System.out.println("Interrupted during put()");
        }
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                LiftOff rocket = rockets.take();
                rocket.run();
            } catch (InterruptedException e) {
                System.out.println("Waking from take()");
            }
        }

        System.out.println("Exiting from take()");
    }

}
