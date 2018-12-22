package com.f.java.concurrent.example.toast;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Toaster implements Runnable {
    private ToastQueue toastQueue;
    private int count = 0;
    Random random = new Random(47);

    public Toaster(ToastQueue toastQueue) {
        this.toastQueue = toastQueue;
    }


    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                TimeUnit.MILLISECONDS.sleep(100 + random.nextInt(500));
                Toast toast = new Toast(count++);
                System.out.println(toast);
                toastQueue.put(toast);
            } catch (InterruptedException e) {
                System.err.println("toaster interrupted");
            }
        }
        System.out.println("toaster off");
    }
}
