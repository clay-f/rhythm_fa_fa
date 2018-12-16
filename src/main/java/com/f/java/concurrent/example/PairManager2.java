package com.f.java.concurrent.example;

public class PairManager2 extends PairManager {
    @Override
    public void increment() {
        Pair tmp;
        synchronized (this) {
            p.incrementY();
            p.incrementX();
            tmp = getPair();
        }
        store(tmp);
    }
}
