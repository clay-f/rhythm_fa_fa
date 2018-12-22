package com.f.java.concurrent.example.toast;

public class Jammer implements Runnable {
    private ToastQueue butteredQueue, finishedQueue;

    public Jammer(ToastQueue butteredQueue, ToastQueue finishedQueue) {
        this.butteredQueue = butteredQueue;
        this.finishedQueue = finishedQueue;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                Toast t = butteredQueue.take();
                t.jam();
                System.out.println(t);
                finishedQueue.put(t);
            } catch (InterruptedException e) {
                System.err.println("jammer interrupted");
            }
        }
        System.out.println("jammer off");
    }
}
