package com.f.java.concurrent.collection;

import com.f.java.concurrent.pool.LiftOff;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class TestBlockingQueues {
    public static void getKey() {
        try {
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void getKey(String message) {
        System.out.println(message);
        getKey();
    }


    public static void test(String msg, BlockingQueue<LiftOff> queue) {
        System.out.println(msg);
        LiftOffRunner runner = new LiftOffRunner(queue);
        Thread t = new Thread(runner);
        t.start();
        for (int i = 0; i < 5; i++) {
            runner.add(new LiftOff(5));
        }
        getKey("Press enter (" + msg + ")");
        t.interrupt();
        System.out.println("Finished " + msg + " test");
    }

    public static void main(String[] args) {
        test("LinkedBlockingQueue", new LinkedBlockingQueue<>());

        test("ArrayLinkedBlockQueue", new ArrayBlockingQueue<>(3));

        test("SynchronousQueue", new SynchronousQueue<>());

    }
}
