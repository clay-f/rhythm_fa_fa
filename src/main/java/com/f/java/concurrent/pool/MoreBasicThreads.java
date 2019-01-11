package com.f.java.concurrent.pool;

import com.f.java.concurrent.example.LiftOff;

public class MoreBasicThreads {
    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new LiftOff()).start();
        }
        System.out.println("wating for liftoff");
    }
}
