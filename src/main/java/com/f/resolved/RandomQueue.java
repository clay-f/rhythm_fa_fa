package com.f.resolved;

import java.util.Objects;

import static com.f.rhythm.helper.SortHelper.shuffle;

public class RandomQueue<T> {

    private T[] queue;
    private Integer n;

    public RandomQueue() {
        n = 0;
        queue = (T[]) new Object[10];
    }

    public boolean isEmpty() {
        return false;
    }

    public void enqueue(T t) {
        Objects.requireNonNull(t);
        queue[++n] = t;
    }

    public T dequeue() {
        shuffle(queue);
        T item = queue[n - 1];
        queue[n-1] = null;
        return item;
    }

    public T simple() {
        return shuffle(queue)[0];
    }


    public static void main(String[] args) {
        RandomQueue<Integer> randomQueue = new RandomQueue<>();
        randomQueue.enqueue(1);
        randomQueue.enqueue(2);
        randomQueue.enqueue(3);
        randomQueue.enqueue(4);
        System.out.println(randomQueue.dequeue());
        System.out.println(randomQueue.simple());
    }
}
