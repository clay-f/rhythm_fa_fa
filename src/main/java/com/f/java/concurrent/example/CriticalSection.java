package com.f.java.concurrent.example;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CriticalSection {
    public static void testApproaches(PairManager pm1, PairManager pm2) {
        var exec = Executors.newCachedThreadPool();
        PairManipulator pmOne = new PairManipulator(pm1);
        PairManipulator pmTwo = new PairManipulator(pm2);

        PairChecker pairCheckerOne = new PairChecker(pm1);
        PairChecker pairCheckerTwo = new PairChecker(pm2);

        exec.execute(pmOne);
        exec.execute(pmTwo);
        exec.execute(pairCheckerOne);
        exec.execute(pairCheckerTwo);

        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("pmOne: " + pmOne + "\npmTwo" + pmTwo);
        System.exit(0);
    }

    public static void main(String[] args) {
        PairManager p1 = new PairManager1(),
                p2 = new PairManager2();

        testApproaches(p1, p2);
    }
}
