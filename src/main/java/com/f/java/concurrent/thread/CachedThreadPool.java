package com.f.java.concurrent.thread;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 2; i++) {
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();
        System.out.println("\n\n");
        ExecutorService executorService1 = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 2; i++) {
            executorService1.execute(new LiftOff());
        }
        executorService1.shutdown();

        ExecutorService executorService2 = Executors.newSingleThreadExecutor();

        for (int i = 0; i<2;i++) {
            executorService2.execute(new LiftOff());
        }
        executorService2.shutdown();

        new Scanner(System.in).next();
    }
}
