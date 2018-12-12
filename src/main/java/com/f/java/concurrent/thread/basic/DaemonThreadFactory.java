package com.f.java.concurrent.thread.basic;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;


public class DaemonThreadFactory {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        var exec = Executors.newFixedThreadPool(10, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread();
                thread.setDaemon(true);
                return thread;
            }
        });
        for (int i = 0; i < 10; i++) {
            exec.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("hello");
                }
            }
            );
        }
        TimeUnit.SECONDS.sleep(10);
        exec.shutdown();
    }
}
