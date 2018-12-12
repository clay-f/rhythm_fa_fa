package com.f.java.concurrent.thread.basic;

import java.util.concurrent.TimeUnit;

public class NumberPlus {
    private int count = 0;

    public synchronized void setCount(int count) {
        count++;
        try {
            TimeUnit.SECONDS.sleep(2);
            count++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.count = count;
        System.out.println(Thread.currentThread().getName() + " cal : " + count);
    }
}
