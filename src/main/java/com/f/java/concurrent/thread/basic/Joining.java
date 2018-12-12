package com.f.java.concurrent.thread.basic;

import java.util.concurrent.TimeUnit;

/**
 *
 * 从一个线程调用另一个线程的 {@link Thread#join()}，会导致等待一段时间直到第二个线程结束才继续执行。
 *
 * 对 join 的调用可以使用 {@link Thread#interrupt()} 打断其调用
 *
 */
public class Joining {
    public static void main(String[] args) throws InterruptedException {
        Sleeper sleeper = new Sleeper(1500, "one");
        Joiner joiner = new Joiner("one-joiner", sleeper);

        Sleeper sleeper1 = new Sleeper(1500, "two");
        Joiner interrupt_thread = new Joiner("interrupt-thread", sleeper1);
        interrupt_thread.interrupt();



        TimeUnit.SECONDS.sleep(10);
    }
}
