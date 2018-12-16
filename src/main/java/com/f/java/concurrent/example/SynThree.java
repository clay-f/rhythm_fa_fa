package com.f.java.concurrent.example;

public class SynThree {
    public static void main(String[] args) {
        ThreeSync threeSync = new ThreeSync();
        new Thread() {
            public void run() {
                threeSync.aPlus();
            }
        }.start();
        new Thread() {
            public void run() {
                threeSync.cPlus();
            }
        }.start();

        threeSync.bPlus();


    }
}
