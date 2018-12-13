package com.f.java.concurrent.thread.lock;

public abstract class IntGenerator {
    private volatile boolean canceld;

    public abstract int next();

    public void cancel() {
        canceld = true;
    }

    public boolean isCanceld() {
        return canceld;
    }

}
