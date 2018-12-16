package com.f.java.concurrent.example;

public class PairManipulator implements Runnable {
    private PairManager pairManager;

    public PairManipulator(PairManager pairManager) {
        this.pairManager = pairManager;
    }

    @Override
    public void run() {
        while (true)
            pairManager.increment();
    }

    @Override
    public String toString() {
        return "Pair: " + pairManager.getPair() + " checkCounter = " + pairManager.checkCounter.get();
    }
}
