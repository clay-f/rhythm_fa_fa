package com.f.java.concurrent.example.deadlock;

public class Chopstick {
    private boolean token = false;

    public synchronized void take() throws InterruptedException {
        while (token)
            wait();
        token = true;
    }

    public synchronized void drop() {
        token = true;
        notifyAll();
    }
}
