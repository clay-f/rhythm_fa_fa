package com.f.java.concurrent;

import com.f.java.base.util.Generator;

import java.util.concurrent.*;
import java.util.*;

class ExchangerProducer<T> implements Runnable {
    private Generator<T> generator;
    private Exchanger<List<T>> exchanger;
    private List<T> holder;

    ExchangerProducer(Exchanger<List<T>> exchg,
                      Generator<T> gen, List<T> holder) {
        exchanger = exchg;
        generator = gen;
        this.holder = holder;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                for (int i = 0; i < ExchangerDemo.size; i++)
                    holder.add(generator.next());
                // Exchange full for empty:
                holder = exchanger.exchange(holder);
            }
        } catch (InterruptedException e) {
            // OK to terminate this way.
        }
    }
}

class ExchangerConsumer<T> implements Runnable {
    private Exchanger<List<T>> exchanger;
    private List<T> holder;
    private volatile T value;

    ExchangerConsumer(Exchanger<List<T>> ex, List<T> holder) {
        exchanger = ex;
        this.holder = holder;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                holder = exchanger.exchange(holder);
                for (T x : holder) {
                    value = x; // Fetch out value
                    System.out.println(value);
                    holder.remove(x); // OK for CopyOnWriteArrayList
                }
            }
        } catch (InterruptedException e) {
            // OK to terminate this way.
        }
        System.out.println("Final value: " + value);
    }
}

public class ExchangerDemo {
    static int size = 10;
    static int delay = 5; // Seconds

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        Exchanger<List<Fat>> xc = new Exchanger<>();
        List<Fat>
                producerList = new CopyOnWriteArrayList<>(),
                consumerList = new CopyOnWriteArrayList<>();
        exec.execute(new ExchangerProducer<>(xc,
                BasicGenerator.create(Fat.class), producerList));
        exec.execute(
                new ExchangerConsumer<>(xc, consumerList));
        TimeUnit.SECONDS.sleep(delay);
        exec.shutdownNow();
    }
} /* Output: (Sample)
Final value: Fat id: 29999
*///:~
