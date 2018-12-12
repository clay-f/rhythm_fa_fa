package com.f.java.concurrent.thread;

import java.util.concurrent.TimeUnit;

/**
 *  daemon 是一种后台线程，这种线程并不属于程序中不可或缺的一部分。一旦所有非后台线程运行完毕，所有后台线程都会结束
 *
 */
public class SimpleDaemons implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread() + " " + this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i=0; i<5; i++) {
            Thread thread = new Thread(new SimpleDaemons());
            thread.setDaemon(true);
            thread.start();
        }

        System.out.println("all daemons started");
        TimeUnit.SECONDS.sleep(10);
    }
}
