package com.f.java.concurrent.thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class AttempLocking {
    private ReentrantLock reentrantLock = new ReentrantLock();

    public void united() {
        var captured = reentrantLock.tryLock();
        try {
            System.out.println("tryLock(): " + captured);
        } finally {
            if (captured)
                reentrantLock.unlock();
        }
    }

    public void timed() {
        var captured = false;
        try {
            captured = reentrantLock.tryLock(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println("tryLock(5, TimeUnit.Seconds): " + captured);
        } finally {
            if (captured)
                reentrantLock.unlock();
        }
    }

    public static void main(String[] args) {
        final AttempLocking al = new AttempLocking();
        al.united();
        al.timed();
        new Thread() {
            {
                setDaemon(true);
            }

            @Override
            public void run() {
                al.reentrantLock.lock();
                System.out.println("required");
            }
        }.start();

        Thread.yield();
        al.united();
        al.timed();
    }
}
