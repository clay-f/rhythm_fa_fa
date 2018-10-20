package com.f.java8.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class SplitTaskTest {
    public static void main(String[] args) {
        System.out.println(forkJoinSum(1_000_000));
    }

    public static long forkJoinSum(long n) {
        long[] numbers = LongStream.rangeClosed(0, n).toArray();
        ForkJoinTask<Long> forkJoinTask = new ForkJoinSumCalculator(numbers);
        return new ForkJoinPool().invoke(forkJoinTask);
    }
}
