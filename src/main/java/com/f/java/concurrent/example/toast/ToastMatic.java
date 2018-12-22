package com.f.java.concurrent.example.toast;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ToastMatic {
    public static void main(String[] args) throws InterruptedException {
        ToastQueue toasts = new ToastQueue(),
                butteredQueue = new ToastQueue(),
                finishedQueue = new ToastQueue();

        var exec = Executors.newCachedThreadPool();
        exec.execute(new Toaster(toasts));
        exec.execute(new Butterer(toasts, butteredQueue));
        exec.execute(new Jammer(butteredQueue, finishedQueue));
        exec.execute(new Eater(finishedQueue));
        TimeUnit.MILLISECONDS.sleep(100);
        exec.shutdown();
    }
}
