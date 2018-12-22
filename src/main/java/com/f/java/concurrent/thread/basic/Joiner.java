package com.f.java.concurrent.thread.basic;

public class Joiner extends Thread {
    private Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            System.err.println("----" + getName() + " ---------");
            sleeper.join();
            System.err.println("----" + getName() + " ---------");
        } catch (InterruptedException e) {
            System.out.println("interrupted");
        }
        System.out.println(getName() + " join completed");
    }
}
