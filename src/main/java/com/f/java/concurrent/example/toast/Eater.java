package com.f.java.concurrent.example.toast;

public class Eater implements Runnable {
    private ToastQueue finishedQueue;
    private int counter = 0;

    public Eater(ToastQueue finishedQueue) {
        this.finishedQueue = finishedQueue;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                Toast t = finishedQueue.take();
                if (t.getId() != counter++ || t.getStatus() != Toast.Status.JAMED) {
                    System.out.println(">>>>> error: " + t);
                } else
                    System.out.println("Chomp! " + t);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Eater off");
    }
}
