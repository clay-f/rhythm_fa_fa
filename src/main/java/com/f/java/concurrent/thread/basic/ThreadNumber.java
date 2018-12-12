package com.f.java.concurrent.thread.basic;

import java.util.concurrent.Executors;

public class ThreadNumber {
    public static void main(String[] args) {
        var exec = Executors.newFixedThreadPool(10);
        NumberPlus numberPlus = new NumberPlus();
        for (int i = 0; i < 10; i++) {
            exec.execute(() -> numberPlus.setCount(1));
        }

        exec.shutdown();
    }


}
