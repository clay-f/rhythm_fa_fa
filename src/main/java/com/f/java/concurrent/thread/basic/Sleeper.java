package com.f.java.concurrent.thread.basic;

public class Sleeper extends Thread {
    private int duration;

    public Sleeper(int duration, String name) {
        super(name);
        this.duration = duration;
        start();
    }

    @Override
    public void run() {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            System.out.println(getName() + " was interrupted " + " isInterrupted(): " + isInterrupted());
        }
        System.out.println(getName() + " has awakened");
    }
}
