package com.f.java.concurrent.thread.lock;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutexEventGenerator extends IntGenerator {
    private int currentEventValue = 0;
    private Lock lock = new ReentrantLock();

    @Override
    public synchronized int next() {
        lock.lock();
        try {
            ++currentEventValue;
            System.out.println("first + 1 " + currentEventValue);
            Thread.yield();
            ++currentEventValue;
            System.out.println("second + 1 " + currentEventValue);
            lock.unlock();
        } finally {
            return currentEventValue;

        }
    }

    public static void main(String[] args) throws InterruptedException {
        var exec = Executors.newFixedThreadPool(3);
        var ge = new SyncronizedEventGenerator();
        for (int i = 0; i < 2; i++) {
            System.out.println("i --> " + i);
            exec.execute(() -> ge.next());
        }

        exec.shutdown();

        TimeUnit.SECONDS.sleep(5);
    }
}
