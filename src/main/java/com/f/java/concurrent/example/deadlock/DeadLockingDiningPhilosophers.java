package com.f.java.concurrent.example.deadlock;

import java.io.IOException;
import java.util.concurrent.Executors;

public class DeadLockingDiningPhilosophers {
    public static void main(String[] args) throws IOException {
        int ponder = 5;

        var exec = Executors.newCachedThreadPool();
        Chopstick[] sticks = new Chopstick[5];
        for (int i = 0; i < 5; i++) {
            sticks[i] = new Chopstick();
        }

        for (int i = 0; i < 5; i++) {
            if (i < 5 - 1) {
                exec.execute(new Philosopher(sticks[i], sticks[i + 1], i, ponder));
            } else {
                exec.execute(new Philosopher(sticks[i], sticks[i], i, ponder));
            }
        }

        System.out.println("press enter to quit");
        System.in.read();
        exec.shutdownNow();
    }
}
