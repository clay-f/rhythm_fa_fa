package com.f.java.concurrent.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExplicitPairManager2 extends PairManager {
    private Lock lock = new ReentrantLock();

    @Override
    public void increment() {
        lock.lock();
        Pair tmp;
        try {
            p.incrementY();
            p.incrementX();
            tmp = getPair();
        } finally {
            lock.unlock();
        }
        store(tmp);
    }
}
