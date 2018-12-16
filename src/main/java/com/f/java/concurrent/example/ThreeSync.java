package com.f.java.concurrent.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreeSync {
    private Object one = new Object();
    private Object two = new Object();

    public synchronized void aPlus() {
        for (int i = 0; i < 2; i++) {
            System.out.println("aPlus -> " + i);
            Thread.yield();
        }
    }

    public void bPlus() {
        Lock lock = new ReentrantLock();

        lock.lock();
        try {
            for (int i = 0; i < 2; i++) {
                System.out.println("bPlus -> " + i);
                Thread.yield();
            }
        } finally {
            lock.unlock();
        }
    }

    public void cPlus() {
        Lock lock = new ReentrantLock();

        lock.lock();
        try {
            for (int i = 0; i < 2; i++) {
                System.out.println("cPlus -> " + i);
                Thread.yield();
            }
        } finally {
            lock.unlock();
        }
    }

}
