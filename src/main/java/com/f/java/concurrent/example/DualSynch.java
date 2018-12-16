package com.f.java.concurrent.example;

public class DualSynch {
    private Object syncObj = new Object();
    public synchronized void f() {
        for (int i = 0; i < 5; i++) {
            System.out.println("f() -> " + i);
            Thread.yield();
        }
    }

    public void g() {
        synchronized (syncObj) {
            for (int i = 0; i < 5; i++) {
                System.out.println("g() -> " + i);
                Thread.yield();
            }
        }
    }
}
